package com.norida.app.Controllers;

import java.util.ArrayList;

import com.norida.app.model.Cycle;
import com.norida.app.model.Metric;

public class MetricController {
	
	public static double averageResults(ArrayList<Metric> metrics) {
		double average=0;
		for(Metric m : metrics) {
			average += m.getResult();
		}
		
		return average / metrics.size();
	}
	
	public static Integer validateMetricName(ArrayList<Metric> metrics, String name) {
		Integer r=1;
		for(Metric c: metrics) {
			if (c.getName().equals(name)) {
				r = 0;
			}
		}
		return r;
	}
	
	
}
