package com.application.jsonApp.domain;

public class ServletMapping {
	
	public String cofaxCDS;
	public String cofaxEmail;
	
	
	public ServletMapping(String cofaxCDS, String cofaxEnail) {
		super();
		this.cofaxCDS = cofaxCDS;
		this.cofaxEmail = cofaxEnail;
	}


	public String getCofaxCDS() {
		return cofaxCDS;
	}


	public void setCofaxCDS(String cofaxCDS) {
		this.cofaxCDS = cofaxCDS;
	}


	public String getCofaxEnail() {
		return cofaxEmail;
	}


	public void setCofaxEnail(String cofaxEnail) {
		this.cofaxEmail = cofaxEnail;
	}
	
	
	

}
