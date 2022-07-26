package com.lti.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {

	String carModel;
	String color;
	Double price;
	String engineType;
	@Autowired
	Tyre tyre;

	
	public Car() {
		super();
	}

	public Car(String carModel, String color, Double price) {
		super();
		this.carModel = carModel;
		this.color = color;
		this.price = price;
	}

	public Car(String carModel, String color, Double price, String engineType) {
		super();
		this.carModel = carModel;
		this.color = color;
		this.price = price;
		this.engineType = engineType;
	}

	public Car(String carModel, String color, Double price, String engineType, Tyre tyre) {
		super();
		this.carModel = carModel;
		this.color = color;
		this.price = price;
		this.engineType = engineType;
		this.tyre = tyre;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}


	public void start() {
		System.out.println("car has started");
	}

	public void showCarDetails() {
		System.out.println("Model: " + carModel);
		System.out.println("Colour: " + color);
		System.out.println("Price: " + price);
		System.out.println("Engine type: " + engineType);
	
	System.out.println(tyre.getMake()+" "+tyre.getSize());}
}
