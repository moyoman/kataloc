package com.kataloc.app2.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductionCountries implements Serializable{

	private static final long serialVersionUID = 5541281835688942418L;
	
	private String iso_3166_1;
	private String name;
	
	@JsonProperty("native_name")
	private String nativeName;
}
