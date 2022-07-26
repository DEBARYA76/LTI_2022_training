package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Insurance;
import com.lti.entity.Person;
import com.lti.entity.Vehicle;

public class GeneralInsuranceDaoImpl implements GeneralInsuranceDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	// Query qry;

	public GeneralInsuranceDaoImpl() {

		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Insurance addOrUpdateInsurance(Insurance insurance) {

		tx.begin();
		Insurance insurancePersisted = em.merge(insurance);
		tx.commit();
		return insurancePersisted;
	}

	public List<Insurance> viewAllInsurances() {
		// TODO Auto-generated method stub
		String jpql = "select ins from Insurance";
		return em.createQuery(jpql).getResultList();

	}

	public Insurance searchInsuranceByNo(int insuranceNo) {
		// TODO Auto-generated method stub

		return em.find(Insurance.class, insuranceNo);

	}

	public List<Insurance> viewAllInsuranceByType(String vehicleType) {

		String jpql = "select ins from Insurance ins where ins.vehicleType=:vt";
		Query query = em.createQuery(jpql);
		query.setParameter("vt", vehicleType);
		return query.getResultList();

	}

	public Vehicle registerOrUpdateVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub

		tx.begin();
		Vehicle persistedVehicle = em.merge(vehicle);
		tx.commit();
		return persistedVehicle;
	}

	public Vehicle searchVehicleById(int vehicleId) {
		// TODO Auto-generated method stub
		return em.find(Vehicle.class, vehicleId);
	}

	public Insurance getInsuranceDetailsByVehicleId(int vehicleId) {
		// TODO Auto-generated method stub

		return searchVehicleById(vehicleId).getInsurance();
	}

	public Vehicle getVehicleDetailsByInsurnceNo(int insuranceNo) {

		return searchInsuranceByNo(insuranceNo).getVehicle();
	}

}
