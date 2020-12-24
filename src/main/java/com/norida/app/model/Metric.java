package com.norida.app.model;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="MetricBean")
public class Metric {
	
	private String nameCycle;
	private Integer id_app;
	private String name;
	private Integer result;
	
	public Metric() {
		
	}
	
	public Metric(String nameCycle, Integer id_app, String name, Integer result) {
		super();
		this.nameCycle = nameCycle;
		this.id_app = id_app;
		this.name = name;
		this.result = result;
	}
	
	
	
	
	public String getNameCycle() {
		return nameCycle;
	}

	public void setNameCycle(String nameCycle) {
		this.nameCycle = nameCycle;
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
	public Integer getResult() {
		return result;
	}
	public void setResult(Integer result) {
		this.result = result;
	}
	
	

}
