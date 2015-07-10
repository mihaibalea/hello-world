package com.application.jsonApp.domain;

public class Taglib {

		private String taglibURI;
		private String taglibLocation;
		
		
		public Taglib(String taglibURI, String taglibLocation) {
			super();
			this.taglibURI = taglibURI;
			this.taglibLocation = taglibLocation;
		}


		public String getTaglibURI() {
			return taglibURI;
		}


		public void setTaglibURI(String taglibURI) {
			this.taglibURI = taglibURI;
		}


		public String getTaglibLocation() {
			return taglibLocation;
		}


		public void setTaglibLocation(String taglibLocation) {
			this.taglibLocation = taglibLocation;
		}
		
		
		
}
