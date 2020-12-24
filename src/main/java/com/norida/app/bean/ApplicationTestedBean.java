package com.norida.app.bean;

import java.util.ArrayList;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.norida.app.model.ApplicationTested;
import com.norida.app.model.Cycle;
import com.norida.app.model.Metric;

@ManagedBean(name="ApplicationBean")
@ApplicationScoped
public class ApplicationTestedBean {
	
	private ArrayList<ApplicationTested> APPS ;
	private Integer IDSELECTED;
	private String VERSION_SELECTED;
	private ArrayList<Cycle> CYCLES_SELECTED;

	@PostConstruct
	public void init() {
		CYCLES_SELECTED = new ArrayList<Cycle>();
		APPS = new ArrayList<ApplicationTested>();
		IDSELECTED = new Integer(0);
		
		APPS.add(new ApplicationTested(1,"SpotyApp","0.1",new ArrayList<Cycle>()));
		APPS.add(new ApplicationTested(2,"TubeApp","0.1",new ArrayList<Cycle>()));
		APPS.add(new ApplicationTested(3,"RadioApp","0.1",new ArrayList<Cycle>()));
		
	}
	
	public ArrayList<ApplicationTested> getAPPS(){
		return APPS;
	}
	
	public String getNameApp() {
		for(ApplicationTested appt : APPS) {
			if(appt.getId() == IDSELECTED) {
				VERSION_SELECTED = appt.getVersion();
				return appt.getName();
			}
		}
		return "";
	}
	
	public void getCycle(){
		for(ApplicationTested appt : APPS) {
			if((appt.getId() == IDSELECTED)&&(appt.getCycles()!= null)) {
				System.out.println("INGRESO IF CYCLES SELECTED ***************");
				CYCLES_SELECTED = appt.getCycles();
				System.out.println("INGRESO IF CYCLES SELECTED ***************" + CYCLES_SELECTED.size());
			}
				
		}
		
	}
	
	public void AddNewCycle(String nameCycle) {
		Cycle newCycle = new Cycle();
		newCycle.setId_app(IDSELECTED);
		newCycle.setName(nameCycle);
		CYCLES_SELECTED.add(newCycle);
		/*for (ApplicationTested appt : APPS) {
			if(appt.getId() == IDSELECTED) {
				System.out.println("INGRESO CYCLE ***********" + CYCLES_SELECTED.size());
			}
		}*/
		//APPS.get(1).setCycles(CYCLES_SELECTED);
	}
	
	public void DeleteApp(Integer appId) {
		ApplicationTested DeleteAppt = new ApplicationTested();
		for (ApplicationTested appt : APPS) {
			if (appt.getId() == appId) {
				DeleteAppt = appt;
			}
		}
		APPS.remove(DeleteAppt);
	}
	
	public void AddApp(String name, String version) {
		APPS.add(new ApplicationTested(maxIdApp(),name, version, new ArrayList<Cycle>()));
		
	}
	
	public String redirectCycle(Integer id) {
		IDSELECTED = id;
		getCycle();
		return "configApp.xhtml";
	}
	
	public String returnIndex() {
		IDSELECTED = 0;
		VERSION_SELECTED = "";
		return "index.xhtml";
	}
	
	public void addVersion(Integer appId,String newVersion) {
		for (ApplicationTested appt : APPS) {
			if (appt.getId() == appId) {
				APPS.add(new ApplicationTested(maxIdApp(), appt.getName(), newVersion, new ArrayList<Cycle>() ));
			}
		}
		
	}
	
	private Integer maxIdApp() {
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for (ApplicationTested appt : APPS) {
			ids.add(appt.getId());
		}
		return Collections.max(ids)+1;
	}
	
	public Integer cycleNum(Integer id) {
		Integer cycleNum=-1;
		for (ApplicationTested appt : APPS) {
			if(appt.getId() == id) {
				cycleNum = appt.getCycles().size();
			}
		}
		return cycleNum;
	}

	
	public void addCycle() {}
	
	

	public Integer getIDSELECTED() {
		return IDSELECTED;
	}

	public void setIDSELECTED(Integer iDSELECTED) {
		IDSELECTED = iDSELECTED;
	}

	public ArrayList<Cycle> getCYCLES_SELECTED() {
		return CYCLES_SELECTED;
	}

	public void setCYCLES_SELECTED(ArrayList<Cycle> cYCLES_SELECTED) {
		CYCLES_SELECTED = cYCLES_SELECTED;
	}

	public void setAPPS(ArrayList<ApplicationTested> aPPS) {
		APPS = aPPS;
	}

	public String getVERSION_SELECTED() {
		return VERSION_SELECTED;
	}

	public void setVERSION_SELECTED(String vERSION_SELECTED) {
		VERSION_SELECTED = vERSION_SELECTED;
	}
	
	
	
	
	
}
