package com.norida.app.model;

import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="CycleBean")
public class Cycle {
	private Integer id_app;
	private String name;
	private ArrayList<Metric> metrics;
	
	
	public Cycle() {
		
	}
	
	public Cycle(Integer id, Integer id_app, String name) {
		super();
		this.id_app = id_app;
		this.name = name;
	}


	

	public ArrayList<Metric> getMetrics() {
		return metrics;
	}


	public void setMetrics(ArrayList<Metric> metrics) {
		this.metrics = metrics;
	}




	public Integer getId_app() {
		return id_app;
	}


	public void setId_app(Integer id_app) {
		this.id_app = id_app;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	

}
