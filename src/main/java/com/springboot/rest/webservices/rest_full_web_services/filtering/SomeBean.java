package com.springboot.rest.webservices.rest_full_web_services.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




//@JsonIgnoreProperties({"field1", "field2"})
@JsonFilter("SomeBeanFilter")
public class SomeBean {
	
	
//	el json ignore se hace cuando deseamos no mandar un valor del objeto y esto afecta a todos los lugares donde mandemos llamar esta clase
	// @JsonIgnore
	private String field1;
	private String field2;
	private String field3;
	
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}


	public String getField1() {
		return field1;
	}


	public String getField2() {
		return field2;
	}


	public String getField3() {
		return field3;
	}


	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	
	
	
	

}
