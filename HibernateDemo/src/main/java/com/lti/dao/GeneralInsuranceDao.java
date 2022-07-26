package com.lti.dao;

import java.util.List;

import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;

public interface GeneralInsuranceDao {

	Insurance addOrUpdateInsurance(Insurance insurance);

	List<Insurance> viewAllInsurances();

	Insurance searchInsuranceByNo(int insuranceNo);

	List<Insurance> viewAllInsuranceByType(String vehicleType);

	Vehicle registerOrUpdateVehicle(Vehicle vehicle);

	Vehicle searchVehicleById(int vehicleId);

	Insurance getInsuranceDetailsByVehicleId(int vehicleId);

	Vehicle getVehicleDetailsByInsurnceNo(int insuranceNo);

}
