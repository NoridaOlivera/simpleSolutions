package com.norida.app.bean;

import java.util.ArrayList;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.norida.app.Controllers.ApplicationController;
import com.norida.app.Controllers.CycleController;
import com.norida.app.Controllers.MetricController;
import com.norida.app.model.ApplicationTested;
import com.norida.app.model.Cycle;
import com.norida.app.model.Metric;

@ManagedBean(name="ApplicationBean")
@ApplicationScoped
public class ApplicationTestedBean {
	
	private ArrayList<ApplicationTested> APPS ;
	private Integer IDSELECTED;
	private String VERSION_SELECTED;
	private String CYCLE_SELECTED;
	private ArrayList<Cycle> CYCLES_SELECTED;
	private ArrayList<Metric> METRICS_SELECTED;
	
	
	@PostConstruct
	public void init() {
		CYCLES_SELECTED = new ArrayList<Cycle>();
		METRICS_SELECTED = new ArrayList<Metric>();
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
				CYCLES_SELECTED = appt.getCycles();
			}
				
		}
		
	}
	
	public void getMetric() {
		System.out.println(CYCLES_SELECTED.size());
		for(Cycle cct : CYCLES_SELECTED) {
			if(cct.getName().equals(CYCLE_SELECTED)) {
				METRICS_SELECTED = cct.getMetrics();
			}
				
		}
	}
	
	public void AddNewCycle(String nameCycle) {
		Integer i = CycleController.validateCycleName(CYCLES_SELECTED, nameCycle);
		if (i==0) {
			String msg = "Error 002: Ya existe el ciclo en esta aplicacion";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String componentId = null;
			facesContext.addMessage(componentId, facesMessage);
			
		}else {
		
		
		
		Cycle newCycle = new Cycle();
		newCycle.setId_app(IDSELECTED);
		newCycle.setMetrics(new ArrayList<Metric>());
		newCycle.setName(nameCycle);
		CYCLES_SELECTED.add(newCycle);
		/*for (ApplicationTested appt : APPS) {
			if(appt.getId() == IDSELECTED) {
				System.out.println("INGRESO CYCLE ***********" + CYCLES_SELECTED.size());
			}
		}*/
		//APPS.get(1).setCycles(CYCLES_SELECTED);
		}
	}
	
	public void AddNewMetric(String nameMetric, Integer result) {
		
		Integer i = MetricController.validateMetricName(METRICS_SELECTED, nameMetric);
		if (i==0) {
			String msg = "Error 003: Ya existe la metrica en este ciclo";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String componentId = null;
			facesContext.addMessage(componentId, facesMessage);
			
		}else {
		
			Metric newMetric = new Metric(CYCLE_SELECTED, IDSELECTED, nameMetric, result);
			METRICS_SELECTED.add(newMetric);
			for (Cycle cct : CYCLES_SELECTED) {
				if(cct.getName().equals(CYCLE_SELECTED)) {
					cct.setMetrics(METRICS_SELECTED);
				}
			}
		}
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
	
	public void DeleteCycle(String nameCycle) {
		Cycle delCycle = new Cycle();
		for(Cycle c : CYCLES_SELECTED) {
			if (c.getName().equals(nameCycle)) {
				System.out.println("VALIDACION BORRADO CYCLE");
				delCycle = c;
			}
		}
		CYCLES_SELECTED.remove(delCycle);
	}
	
	public void AddApp(String name, String version) {
		Integer i = 1;
		i= ApplicationController.validationApp(name, version, APPS);
		
		if (i==0) {
			String msg = "Error 001: Ya existe esta aplicacion en la version ingresada";
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			String componentId = null;
			facesContext.addMessage(componentId, facesMessage);
			
		}else {
		APPS.add(new ApplicationTested(maxIdApp(),name, version, new ArrayList<Cycle>()));
		}
		
	}
	
	public String redirectCycle(Integer id) {
		IDSELECTED = id;
		getCycle();
		return "configApp.xhtml";
	}
	
	public String redirectMetric(String nameC) {
		CYCLE_SELECTED = nameC;
		getMetric();
		return "metrics.xhtml";
	}
	
	public String returnIndex() {
		IDSELECTED = 0;
		VERSION_SELECTED = "";
		return "index.xhtml";
	}
	
	public String returnCycle() {
		return "configApp.xhtml";
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
	
	public Integer metricNum(String cycleName) {
		Integer metricNum=-1;
		for (Cycle cct : CYCLES_SELECTED) {
			if(cct.getName().equals(cycleName)) {
				metricNum = cct.getMetrics().size();
			}
		}
		return metricNum;
	}
	
	public double averageMetrics(ArrayList<Metric> AvMetrics) {
		return (double)Math.round(MetricController.averageResults(AvMetrics));
	}
	
	public double averageAppResults(Integer idApp) {
		double AvgApp=0;
		for (ApplicationTested app : APPS) {
			if (app.getId()==idApp) {
				AvgApp = ApplicationController.averageApp(app);
			}
		}
		return (double)Math.round(AvgApp);
	}

	
	

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

	public String getCYCLE_SELECTED() {
		return CYCLE_SELECTED;
	}

	public void setCYCLE_SELECTED(String cYCLE_SELECTED) {
		CYCLE_SELECTED = cYCLE_SELECTED;
	}

	public ArrayList<Metric> getMETRICS_SELECTED() {
		return METRICS_SELECTED;
	}

	public void setMETRICS_SELECTED(ArrayList<Metric> mETRICS_SELECTED) {
		METRICS_SELECTED = mETRICS_SELECTED;
	}
	
	
	
	
	
}
