package com.traveller.app.trip.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.traveller.app.trip.dto.RequestDto;
import com.traveller.app.trip.entities.Request;
import com.traveller.app.trip.service.RequestService;

@RestController
@RequestMapping("/request")
public class RequestController {
	@Autowired
	RequestService requestService;

	@PostMapping
	public ResponseEntity<Request> createRequest(@RequestBody RequestDto requestDto) {
		Request createdRequest = requestService.createRequest(requestDto);
		return ResponseEntity.ok(createdRequest);
	}

	@GetMapping
	public ResponseEntity<RequestDto> getRequest(@RequestParam("id") int id) {
		RequestDto requestDto = requestService.getRequest(id);
		return ResponseEntity.ok(requestDto);
	}

	@PatchMapping
	public ResponseEntity<RequestDto> updateRequest(@RequestParam("id") int id, @RequestBody Map<String, String> updatedFields) {
		RequestDto updatedRequestDto = requestService.updateRequest(id, updatedFields);
		return ResponseEntity.ok(updatedRequestDto);
	}
	@PostMapping("/updateStatus")
	public ResponseEntity<String> updateStatus(@RequestParam("id") int id,@RequestParam("status") String status) {
		requestService.updateStatus(id, status);
		return ResponseEntity.ok("updated status successfully");
	}
}
