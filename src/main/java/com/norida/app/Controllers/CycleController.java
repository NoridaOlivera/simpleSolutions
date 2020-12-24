package com.norida.app.Controllers;

import java.util.ArrayList;
import java.util.Arrays;

import com.norida.app.model.Cycle;

public class CycleController {

	
	public static Integer validateCycleName(ArrayList<Cycle> cycles, String name) {
		Integer r=1;
		for(Cycle c: cycles) {
			if (c.getName().equals(name)) {
				r = 0;
			}
		}
		return r;
	}
	
}
