package com.norida.app.model;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="MetricBean")
public class Metric {
	
	private Integer id;
	private Integer id_cycle;
	private Integer id_app;
	private String name;
	private Integer result;
	
	
	
	public Metric(Integer id, Integer id_cycle, Integer id_app, String name, Integer result) {
		super();
		this.id = id;
		this.id_cycle = id_cycle;
		this.id_app = id_app;
		this.name = name;
		this.result = result;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getId_cycle() {
		return id_cycle;
	}
	public void setId_cycle(Integer id_cycle) {
		this.id_cycle = id_cycle;
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
