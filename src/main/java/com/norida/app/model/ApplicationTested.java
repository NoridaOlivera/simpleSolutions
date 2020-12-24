package com.norida.app.model;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="ApplicationTested")
public class ApplicationTested {
	
	private Integer id;
	private String name;
	private String version;
	private ArrayList<Cycle> cycles;
	
	public ApplicationTested() {
		
	}
	
	public ApplicationTested(String name, String version,ArrayList<Cycle> cycles ) {
		this.name = name;
		this.version = version;
		this.cycles = cycles;
		
	}
	
	public ApplicationTested(Integer id, String name, String version , ArrayList<Cycle> cycles) {
		this.id = id;
		this.name = name;
		this.version = version;
		this.cycles = cycles;
		
	}
	
	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public ArrayList<Cycle> getCycles() {
		return cycles;
	}

	public void setCycles(ArrayList<Cycle> cycles) {
		this.cycles = cycles;
	}


	
	
	
	

}
