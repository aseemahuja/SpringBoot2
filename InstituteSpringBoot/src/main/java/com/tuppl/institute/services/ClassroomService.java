package com.tuppl.institute.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.tuppl.institute.data.ClassroomDataSource;
import com.tuppl.institute.model.Classroom;
import com.tuppl.institute.model.GetClassroomByIdResponse;
import com.tuppl.institute.rest.client.StudentEmpClient;
import com.tuppl.institute.rest.model.GetEmployeeListResponse;
import com.tuppl.institute.rest.model.GetStudentListResponse;
import com.tuppl.institute.rest.model.Student;
import com.tuppl.institute.rest.model.StudentDataRequest;

@Service
public class ClassroomService {
	
	@Autowired
	StudentEmpClient restClient;
	@Autowired
	ClassroomDataSource classroomDataSource;
	
	public GetClassroomByIdResponse classroomDataById(String classroomId) {
		GetClassroomByIdResponse response = new GetClassroomByIdResponse();
		
		GetStudentListResponse studentListResponse = restClient.getStudentList(); 
		GetEmployeeListResponse employeeListResponse = restClient.getEmployeeList(); 
		
		List<Classroom> classroomList = classroomDataSource.getClassRoomList();
		Optional<Classroom> classroomOptional = classroomList
				.stream()
				.filter(classroom -> classroomId.compareTo(classroom.getId())==0)
				.findFirst();
		
		if(!classroomOptional.isPresent()) {
			response.setErrorMessage("Classroom Id not found");
			
		} else {
			response.setClassroom(classroomOptional.get());
			if(!CollectionUtils.isEmpty(studentListResponse.getStudentList())) {
				response
				.getClassroom()
				.setStudentList(
						studentListResponse.getStudentList()
						.stream()
						.filter(student -> classroomId.equalsIgnoreCase(student.getClassId()))
						.collect(Collectors.toList())
						);
			}
			
			if(null!=employeeListResponse && !CollectionUtils.isEmpty(employeeListResponse.getEmployeeList())) {
				response
				.getClassroom()
				.setTeacher(
						employeeListResponse.getEmployeeList()
						.stream()
						.filter(employee -> classroomId.equalsIgnoreCase(employee.getClassId()))
						.findFirst()
						.orElse(null)
						);
			}
		}
		
		return response;
	}
	
	public GetClassroomByIdResponse addStudentToClass(StudentDataRequest studentDataRequest, String classroomId) {
		GetClassroomByIdResponse response = new GetClassroomByIdResponse();
		
		List<Classroom> classroomList = classroomDataSource.getClassRoomList();
		
		Optional<Classroom> classroomOptional = classroomList
				.stream()
				.filter(classroom -> classroomId.compareTo(classroom.getId())==0)
				.findFirst();
		
		if(!classroomOptional.isPresent()) {
			response.setErrorMessage("Classroom Id not found");
			
		} else {
			response.setClassroom(classroomOptional.get());
			GetStudentListResponse addStudentResponse = restClient.addStudent(studentDataRequest);
			
			if(null!=addStudentResponse && !CollectionUtils.isEmpty(addStudentResponse.getStudentList())) {
				response
				.getClassroom()
				.setStudentList(
						addStudentResponse.getStudentList()
						.stream()
						.filter(student -> classroomId.equalsIgnoreCase(student.getClassId()))
						.collect(Collectors.toList())
						);
			}
		}
		
		return response;
		
	}

}
