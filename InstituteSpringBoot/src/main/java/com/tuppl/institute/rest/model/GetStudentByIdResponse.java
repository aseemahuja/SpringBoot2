package com.tuppl.institute.rest.model;

public class GetStudentByIdResponse extends CommonResponse{
	Student student;
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
