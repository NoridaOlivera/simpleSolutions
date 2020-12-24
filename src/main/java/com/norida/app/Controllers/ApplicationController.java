package com.norida.app.Controllers;

import java.util.ArrayList;

import com.norida.app.model.ApplicationTested;
import com.norida.app.model.Cycle;
import com.norida.app.model.Metric;

public class ApplicationController {
	
	public static double averageApp(ApplicationTested appt) {
		double avgC=0;
		for(Cycle c : appt.getCycles()) {
			if(c.getMetrics().size()>0) {
				avgC += MetricController.averageResults(c.getMetrics());
			}
		}
		return avgC = avgC / appt.getCycles().size();
		
		
		
	}

}
