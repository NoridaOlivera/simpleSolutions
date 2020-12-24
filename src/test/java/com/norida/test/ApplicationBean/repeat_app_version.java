package com.norida.test.ApplicationBean;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.norida.app.Controllers.ApplicationController;
import com.norida.app.Controllers.MetricController;
import com.norida.app.model.ApplicationTested;
import com.norida.app.model.Cycle;
import com.norida.app.model.Metric;

public class repeat_app_version {

	@Test
	public void validationAppTest() {
		String name = "SpotyApp";
		String version = "0.1";
		ArrayList<ApplicationTested> APPS = new ArrayList<ApplicationTested>();
		APPS.add(new ApplicationTested(1,"SpotyApp","0.1",new ArrayList<Cycle>()));
		APPS.add(new ApplicationTested(2,"TubeApp","0.1",new ArrayList<Cycle>()));
		APPS.add(new ApplicationTested(3,"RadioApp","0.1",new ArrayList<Cycle>()));
		
		assertEquals(ApplicationController.validationApp(name, version, APPS),0);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void averageAppTest() {
		double delta=0;
		ArrayList<Metric> metricsTest = new ArrayList<Metric>();
		ArrayList<Cycle> cycleTest = new ArrayList<Cycle>();
		ArrayList<ApplicationTested> APPS = new ArrayList<ApplicationTested>();
		metricsTest.add(new Metric("Cycle1",1,"metric1",20));
		metricsTest.add(new Metric("Cycle1",1,"metric2",40));
		metricsTest.add(new Metric("Cycle1",1,"metric3",30));
		cycleTest.add(new Cycle(1,"Cycle1",metricsTest));
		APPS.add(new ApplicationTested(1,"SpotyApp","0.1",cycleTest));
		
		assertEquals(ApplicationController.averageApp(APPS.get(0)),30,delta);
		
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void avg_cycle_test() {
		double delta=0;
		ArrayList<Metric> metricsTest = new ArrayList<Metric>();
		metricsTest.add(new Metric("Cycle1",1,"metric1",20));
		metricsTest.add(new Metric("Cycle1",1,"metric2",40));
		
		assertEquals(MetricController.averageResults(metricsTest),30,delta);
		
	}
	

}
