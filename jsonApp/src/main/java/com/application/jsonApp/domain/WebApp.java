package com.application.jsonApp.domain;

import java.util.List;

public class WebApp {

	private List<Servlet> servlet;
	private ServletMapping servletMapping;
	private Taglib tagLib;

	public WebApp() {
	}

	public WebApp(List<Servlet> servlet, ServletMapping servletMapping, Taglib tagLib) {
		super();
		this.servlet = servlet;
		this.servletMapping = servletMapping;
		this.tagLib = tagLib;
	}

	public List<Servlet> getServlet() {
		return servlet;
	}

	public void setServlet(List<Servlet> servlet) {
		this.servlet = servlet;
	}

	public ServletMapping getServletMapping() {
		return servletMapping;
	}

	public void setServletMapping(ServletMapping servletMapping) {
		this.servletMapping = servletMapping;
	}

	public Taglib getTagLib() {
		return tagLib;
	}

	public void setTagLib(Taglib tagLib) {
		this.tagLib = tagLib;
	}

	@Override
	public String toString() {
		return "WebApp [servlet=" + servlet.toString() + ", servletMapping=" + servletMapping + ", tagLib="
				+ tagLib + "]";
	}

}
