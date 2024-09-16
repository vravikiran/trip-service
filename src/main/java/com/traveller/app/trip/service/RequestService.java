package com.traveller.app.trip.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traveller.app.trip.dto.RequestDto;
import com.traveller.app.trip.entities.Request;
import com.traveller.app.trip.repostiory.RequestRepository;

@Service
public class RequestService {
	@Autowired
	private RequestRepository requestRepository;

	public Request createRequest(RequestDto requestDto) {
		Request request = convertRequestDtoToRequest(requestDto);
		return requestRepository.save(request);
	}

	public RequestDto getRequest(int id) {
		if (requestRepository.existsById(id)) {
			Request request = requestRepository.findById(id).get();
			return convertRequestToRequestDto(request);
		} else {
			throw new NoSuchElementException();
		}
	}

	public RequestDto updateRequest(int id, Map<String, String> updatedFields) {
		Request request = null;
		if (requestRepository.existsById(id)) {
			request = requestRepository.findById(id).get();
			RequestDto requestDto = convertRequestToRequestDto(request);
			requestDto.updateValues(requestDto, updatedFields);
			Request updatedReq = convertRequestDtoToRequest(requestDto);
			requestRepository.save(updatedReq);
			return requestDto;
		} else {
			throw new NoSuchElementException();
		}
	}
	
	public void updateStatus(int id,String status) {
		requestRepository.updateStatus(id, status);
	}

	private Request convertRequestDtoToRequest(RequestDto requestDto) {
		Request request = new Request();
		request.setIsfoodrequired(requestDto.isIsfoodrequired());
		request.setIsvehiclerequired(requestDto.isIsvehiclerequired());
		request.setIsroomrequired(requestDto.isIsroomrequired());
		request.setMainlocation(requestDto.getMainlocation());
		if (requestDto.getOthertravellers() != null) {
			request.setOthertravellers(String.join(",", requestDto.getOthertravellers()));
		}
		if (requestDto.getOtherlocations() != null) {
			request.setOtherlocations(String.join(",", requestDto.getOtherlocations()));
		}
		request.setStartdate(LocalDate.parse(requestDto.getStartdate()));
		request.setEnddate(LocalDate.parse(requestDto.getEnddate()));
		request.setNoofpersons(requestDto.getNoofpersons());
		request.setPlantype(requestDto.getPlantype());
		request.setMaintraveller(requestDto.getMaintraveller());
		request.setTravellerid(requestDto.getTravellerid());
		request.setStatus(requestDto.getStatus());
		request.setId(requestDto.getId());
		return request;
	}

	private RequestDto convertRequestToRequestDto(Request request) {
		RequestDto requestDto = new RequestDto();
		requestDto.setId(request.getId());
		requestDto.setIsfoodrequired(request.isIsfoodrequired());
		requestDto.setIsroomrequired(request.isIsroomrequired());
		requestDto.setIsvehiclerequired(request.isIsvehiclerequired());
		requestDto.setMainlocation(request.getMainlocation());
		requestDto.setMaintraveller(request.getMaintraveller());
		requestDto.setNoofpersons(request.getNoofpersons());
		requestDto.setPlantype(request.getPlantype());
		requestDto.setStatus(request.getStatus());
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (request.getStartdate() != null) {
			requestDto.setStartdate(request.getStartdate().format(dateTimeFormatter));
		}
		if (request.getEnddate() != null) {
			requestDto.setEnddate(request.getEnddate().format(dateTimeFormatter));
		}
		if (request.getOtherlocations() != null && request.getOtherlocations().isEmpty()) {
			requestDto.setOtherlocations(Arrays.asList(request.getOtherlocations().split(",")));
		}
		if (request.getOthertravellers() != null && request.getOthertravellers().isEmpty()) {
			requestDto.setOthertravellers(Arrays.asList(request.getOthertravellers().split(",")));
		}
		requestDto.setTravellerid(request.getTravellerid());
		return requestDto;
	}
}
