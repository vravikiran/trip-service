package com.traveller.app.trip.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String status;
	private LocalDate startdate;
	private LocalDate enddate;
	private int noofpersons;
	private boolean isroomrequired;
	private boolean isvehiclerequired;
	private boolean isfoodrequired;
	private String mainlocation;
	private String otherlocations;
	private String plantype;
	@Column(updatable = false)
	private int travellerid;
	@Column(updatable = false)
	private String maintraveller;
	private String othertravellers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getStartdate() {
		return startdate;
	}

	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}

	public LocalDate getEnddate() {
		return enddate;
	}

	public void setEnddate(LocalDate enddate) {
		this.enddate = enddate;
	}

	public int getNoofpersons() {
		return noofpersons;
	}

	public void setNoofpersons(int noofpersons) {
		this.noofpersons = noofpersons;
	}

	public boolean isIsroomrequired() {
		return isroomrequired;
	}

	public void setIsroomrequired(boolean isroomrequired) {
		this.isroomrequired = isroomrequired;
	}

	public boolean isIsvehiclerequired() {
		return isvehiclerequired;
	}

	public void setIsvehiclerequired(boolean isvehiclerequired) {
		this.isvehiclerequired = isvehiclerequired;
	}

	public boolean isIsfoodrequired() {
		return isfoodrequired;
	}

	public void setIsfoodrequired(boolean isfoodrequired) {
		this.isfoodrequired = isfoodrequired;
	}

	public String getMainlocation() {
		return mainlocation;
	}

	public void setMainlocation(String mainlocation) {
		this.mainlocation = mainlocation;
	}

	public String getOtherlocations() {
		return otherlocations;
	}

	public void setOtherlocations(String otherlocations) {
		this.otherlocations = otherlocations;
	}

	public String getPlantype() {
		return plantype;
	}

	public void setPlantype(String plantype) {
		this.plantype = plantype;
	}

	public int getTravellerid() {
		return travellerid;
	}

	public void setTravellerid(int travellerid) {
		this.travellerid = travellerid;
	}

	public String getMaintraveller() {
		return maintraveller;
	}

	public void setMaintraveller(String maintraveller) {
		this.maintraveller = maintraveller;
	}

	public String getOthertravellers() {
		return othertravellers;
	}

	public void setOthertravellers(String othertravellers) {
		this.othertravellers = othertravellers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(enddate, id, isfoodrequired, isroomrequired, isvehiclerequired, mainlocation,
				maintraveller, noofpersons, otherlocations, othertravellers, plantype, startdate, status, travellerid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		return Objects.equals(enddate, other.enddate) && id == other.id && isfoodrequired == other.isfoodrequired
				&& isroomrequired == other.isroomrequired && isvehiclerequired == other.isvehiclerequired
				&& Objects.equals(mainlocation, other.mainlocation)
				&& Objects.equals(maintraveller, other.maintraveller) && noofpersons == other.noofpersons
				&& Objects.equals(otherlocations, other.otherlocations)
				&& Objects.equals(othertravellers, other.othertravellers) && Objects.equals(plantype, other.plantype)
				&& Objects.equals(startdate, other.startdate) && Objects.equals(status, other.status)
				&& travellerid == other.travellerid;
	}

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
}
