package com.tuppl.institute.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetClassroomListResponse extends CommonResponse{
	
	List<Classroom> classroomList;

	public List<Classroom> getClassroomList() {
		return classroomList;
	}

	public void setClassroomList(List<Classroom> classroomList) {
		this.classroomList = classroomList;
	}

}
