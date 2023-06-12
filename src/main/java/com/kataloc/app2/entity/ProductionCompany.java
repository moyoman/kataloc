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
public class ProductionCompany implements Serializable{

	private static final long serialVersionUID = -4106242516413656485L;
	
	private String description;
	private String headquarters;
	private String homepage;
	private int id;
	@JsonProperty("logo_path")
	private String logoPath;
	private String name;
	@JsonProperty("origin_country")
	private String originCountry;	
	
}
