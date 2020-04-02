package com.tuppl.institute.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tuppl.institute.rest.model.Employee;
import com.tuppl.institute.rest.model.Student;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Classroom {
	
	String name;
	String id;
	int chairs;
	int tables;
	boolean hasProjector;
	List<Student> studentList;
	Employee teacher;
	public Employee getTeacher() {
		return teacher;
	}
	public void setTeacher(Employee teacher) {
		this.teacher = teacher;
	}
	public List<Student> getStudentList() {
		return studentList;
	}
	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getChairs() {
		return chairs;
	}
	public void setChairs(int chairs) {
		this.chairs = chairs;
	}
	public int getTables() {
		return tables;
	}
	public void setTables(int tables) {
		this.tables = tables;
	}
	public boolean isHasProjector() {
		return hasProjector;
	}
	public void setHasProjector(boolean hasProjector) {
		this.hasProjector = hasProjector;
	}

}
