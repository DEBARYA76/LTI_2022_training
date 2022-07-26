package com.lti.entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_insurance")
public class Insurance {

	@Id
	@SequenceGenerator(name = "ins_seq", initialValue = 1001, allocationSize = 1)
	@GeneratedValue(generator = "ins_seq", strategy = GenerationType.SEQUENCE)
	int insuranceNo;

	String companyName;
	double premiumAmount;
	int noOfYears;
	String vehicleType;

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	Vehicle vehicle;

	public int getInsuranceNo() {
		return insuranceNo;
	}

	public void setInsuranceNo(int insuranceNo) {
		this.insuranceNo = insuranceNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public int getNoOfYears() {
		return noOfYears;
	}

	public void setNoOfYears(int noOfYears) {
		this.noOfYears = noOfYears;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
