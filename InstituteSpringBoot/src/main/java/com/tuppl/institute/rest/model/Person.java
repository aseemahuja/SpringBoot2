package com.tuppl.institute.rest.model;

public class Person {
	String firstName;
	String lastName;
	String address;
	String city;
	String state;
	boolean hasLaptop;
	String classId;
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isHasLaptop() {
		return hasLaptop;
	}
	public void setHasLaptop(boolean hasLaptop) {
		this.hasLaptop = hasLaptop;
	}
	

}
