package com.tuppl.institute.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tuppl.institute.model.Classroom;

@Service
public class ClassroomDataSource {
	
	public List<Classroom> getClassRoomList(){
		List<Classroom> classroomList = new ArrayList<>();
		
		Classroom classroom = null;
		for(int i=0;i<5;i++) {
			classroom = new Classroom();
			classroom.setChairs(5+i);
			classroom.setTables(2+i);
			classroom.setId("class_" +i);
			classroom.setHasProjector(true);
			classroom.setName("className" +i);
			
			classroomList.add(classroom);
		}
		
		return classroomList;
	}

}
