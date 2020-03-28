package com.tuppl.institute.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Classroom {
	
	String name;
	String id;
	int chairs;
	int tables;
	boolean hasProjector;
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
