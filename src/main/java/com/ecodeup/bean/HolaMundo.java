package com.ecodeup.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="holaMundo")
@SessionScoped
public class HolaMundo {
	private String saludo="Hola Mundo desde JSF para java WEB!!";

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}	

}
