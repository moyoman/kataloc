package com.kataloc.app2.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAlias;
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
public class SpokenLanguages implements Serializable{

	private static final long serialVersionUID = -3007553277760874052L;
	
	@JsonAlias("iso_3166_1")
	private String iso_639_1;
	@JsonProperty("english_name")
	private String englishName;
	@JsonAlias("native_name")
	private String name;
	
}
