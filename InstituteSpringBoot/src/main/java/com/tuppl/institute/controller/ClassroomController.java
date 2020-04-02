package com.tuppl.institute.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tuppl.institute.data.ClassroomDataSource;
import com.tuppl.institute.exception.ServiceException;
import com.tuppl.institute.model.Classroom;
import com.tuppl.institute.model.ClassroomDataRequest;
import com.tuppl.institute.model.GetClassroomByIdResponse;
import com.tuppl.institute.model.GetClassroomListResponse;
import com.tuppl.institute.rest.model.StudentDataRequest;
import com.tuppl.institute.services.ClassroomService;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
	
	@Autowired
	ClassroomDataSource classroomDataSource;
	
	@Autowired
	ClassroomService classroomService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassroomController.class);
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ResponseEntity<GetClassroomListResponse> getList(){
		GetClassroomListResponse response = new GetClassroomListResponse();
		response.setClassroomList(classroomDataSource.getClassRoomList());
		
		//null!=response.getClassroomList() && !response.getClassroomList().isEmpty()
		if(!CollectionUtils.isEmpty(response.getClassroomList())) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			throw new ServiceException("DATA_NOT_FOUND");
		}
	}
	
	@RequestMapping(value="/byId/{classroomId}", method= RequestMethod.GET)
	public ResponseEntity<GetClassroomByIdResponse> classroomDataById(@PathVariable(value="classroomId") String classroomId){

		if(StringUtils.isEmpty(classroomId)) {
			throw new ServiceException("CLASSROOM_ID_NOT_FOUND");
		}
		
		GetClassroomByIdResponse response = classroomService.classroomDataById(classroomId);
		
		if(null== response.getClassroom()) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="/add", method= RequestMethod.POST)
	public ResponseEntity<GetClassroomListResponse> addClassroom(@RequestBody ClassroomDataRequest classroomDataRequest){
		GetClassroomListResponse response = new GetClassroomListResponse();
		if(null== classroomDataRequest
				|| null== classroomDataRequest.getClassroom()
				|| StringUtils.isEmpty(classroomDataRequest.getClassroom().getName())) {
			response.setErrorMessage("Classroom details not found in request.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		List<Classroom> classroomList = classroomDataSource.getClassRoomList();
		classroomList.add(classroomDataRequest.getClassroom());
		response.setClassroomList(classroomList);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addStudent/{classroomId}", method=RequestMethod.POST)
	public ResponseEntity<GetClassroomByIdResponse> addStudentToClass(
			@RequestBody StudentDataRequest studentDataRequest, @PathVariable(value="classroomId") String classroomId){
		GetClassroomByIdResponse response = new GetClassroomByIdResponse();
		
		if(StringUtils.isEmpty(classroomId) || null== studentDataRequest) {
			response.setErrorMessage("Request is invalid.");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		
		response = classroomService.addStudentToClass(studentDataRequest, classroomId);
		
		if(!StringUtils.isEmpty(response.getErrorMessage())) {
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
	}
	
	
	
	
	

}
