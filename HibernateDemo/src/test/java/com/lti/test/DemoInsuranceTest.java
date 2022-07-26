package com.lti.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.lti.dao.GeneralInsuranceDao;
import com.lti.dao.GeneralInsuranceDaoImpl;
import com.lti.entity.Insurance;
import com.lti.entity.Vehicle;

public class DemoInsuranceTest {

	GeneralInsuranceDao dao = new GeneralInsuranceDaoImpl();


     @Test
     public void test()
     {
    	 System.out.println("error not found");
     }
     
     
	@Test
	public void addOrUpdateVehicle() {
		Vehicle vehicle = new Vehicle();
		vehicle.setBrand("HYUN");
		vehicle.setModelNo("Grandi10");
		vehicle.setRegistrationNo("WBJ3245");
		vehicle.setVehicleType("4-wheller");

		Vehicle vehicle2 = dao.registerOrUpdateVehicle(vehicle);

		assertNotNull(vehicle2);
	}

	@Test
	public void searchVehicleById() {

		Vehicle vehicle = dao.searchVehicleById(5003);
		assertNotNull(vehicle);
	}

	@Test
	public void addOrUpdateInsurance() {
		Insurance insurance = new Insurance();
		Vehicle vehicle = dao.searchVehicleById(5003);
		insurance.setCompanyName("Toyota");
		insurance.setPremiumAmount(45000);
		insurance.setNoOfYears(4);
		insurance.setVehicleType("2-wheller");
		insurance.setVehicle(vehicle);

		Insurance insurance1 = dao.addOrUpdateInsurance(insurance);
		assertNotNull(insurance1);

	}

	public void viewAllInsurances() {

	}

	public void registerOrUpdateVehicle() {

	}

	public void viewAllInsuranceByType(String vehicleType)

	{
	}

	public void getInsuranceDetailsByVehicleId(int vehicleId) {
	}

	public void getVehicleDetailsByInsurnceNo(int insuranceNo) {
	}
}
