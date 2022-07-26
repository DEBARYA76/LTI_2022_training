package com.lti.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_vehicle")
public class Vehicle {
	@Id
	@SequenceGenerator(name = "veh_seq", initialValue = 5001, allocationSize = 1)
	@GeneratedValue(generator = "veh_seq", strategy = GenerationType.SEQUENCE)
	int VehicleId;

	String registrationNo;
	String vehicleType;
	String brand;
	String modelNo;

	@OneToOne(mappedBy = "vehicle")
	Insurance insurance;

	public int getVehicleId() {
		return VehicleId;
	}

	public void setVehicleId(int vehicleId) {
		VehicleId = vehicleId;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

}
