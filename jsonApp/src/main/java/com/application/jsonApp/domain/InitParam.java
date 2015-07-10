package com.application.jsonApp.domain;

public class InitParam {

	private String templatePath;
	private String templateOverridePath;
	private String useJSP;
	private String dataLog;
	private String mailHost;
	private String mailHostOverride;
	private String logLocation;

	public InitParam(String templatePath, String templateOverridePath, String useJSP, String dataLog, String mailHost,
			String mailHostOverride, String logLocation) {
		super();
		this.templatePath = templatePath;
		this.templateOverridePath = templateOverridePath;
		this.useJSP = useJSP;
		this.dataLog = dataLog;
		this.mailHost = mailHost;
		this.mailHostOverride = mailHostOverride;
		this.logLocation = logLocation;
	}

	
	
	public String getTemplatePath() {
		return templatePath;
	}

	public void setTemplatePath(String templatePath) {
		this.templatePath = templatePath;
	}

	public String getTemplateOverridePath() {
		return templateOverridePath;
	}

	public void setTemplateOverridePath(String templateOverridePath) {
		this.templateOverridePath = templateOverridePath;
	}

	public String isUseJSP() {
		return useJSP;
	}

	public void setUseJSP(String useJSP) {
		this.useJSP = useJSP;
	}

	public String getDataLog() {
		return dataLog;
	}

	public void setDataLog(String dataLog) {
		this.dataLog = dataLog;
	}

	public String getMailHost() {
		return mailHost;
	}

	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}

	public String getMailHostOverride() {
		return mailHostOverride;
	}

	public void setMailHostOverride(String mailHostOverride) {
		this.mailHostOverride = mailHostOverride;
	}

	public String getLogLocation() {
		return logLocation;
	}

	public void setLogLocation(String logLocation) {
		this.logLocation = logLocation;
	}


	@Override
	public String toString() {
		return "templatePath=" + templatePath + "\n templateOverridePath=" + templateOverridePath
				+ "\n useJSP=" + useJSP + "\n dataLog=" + dataLog + "\n mailHost=" + mailHost + "\n mailHostOverride="
				+ mailHostOverride + "\n logLocation=" + logLocation; 
	}

	
	
}
