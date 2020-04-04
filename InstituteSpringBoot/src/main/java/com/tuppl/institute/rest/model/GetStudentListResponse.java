package com.tuppl.institute.rest.model;

import java.util.List;

public class GetStudentListResponse extends CommonResponse{
	List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> sudentList) {
		this.studentList = sudentList;
	}
	

}
