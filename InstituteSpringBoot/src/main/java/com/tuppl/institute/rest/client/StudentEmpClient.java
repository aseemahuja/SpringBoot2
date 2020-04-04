package com.tuppl.institute.rest.client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tuppl.institute.rest.model.GetEmployeeListResponse;
import com.tuppl.institute.rest.model.GetStudentListResponse;
import com.tuppl.institute.rest.model.StudentDataRequest;

@Service
public class StudentEmpClient {
	
	RestTemplate restTemplate;
	
	public StudentEmpClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }
	
	public GetStudentListResponse getStudentList() {
		
		String url = "http://localhost:8081/msapi/student/list";
		GetStudentListResponse response = restTemplate.getForObject(url, GetStudentListResponse.class);
		
		return response;
	}
	
	public GetEmployeeListResponse getEmployeeList() {
		
		String url = "http://localhost:8081/msapi/employee/list";
		GetEmployeeListResponse response = restTemplate.getForObject(url, GetEmployeeListResponse.class);
		
		return response;
	}
	
	public GetStudentListResponse addStudent(StudentDataRequest studentDataRequest) {
		String url = "http://localhost:8081/msapi/student/add";
		
		GetStudentListResponse response = restTemplate.postForObject(url, studentDataRequest, GetStudentListResponse.class);
		
		return response;
	}
	
	

}
