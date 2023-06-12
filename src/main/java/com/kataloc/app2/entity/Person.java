package com.kataloc.app2.entity;

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
public class Person {

	private boolean adult;
	private int gender;
	private int id;
	@JsonProperty("known_for_department")
	private String knownForDepartment;
	private String name;
	@JsonProperty("original_name")
	private String originalName;
	private int popularity;
	@JsonProperty("profile_path")
	private String profilePath;
	@JsonProperty("cast_id")
	private int castId;
	private String character;
	@JsonProperty("credit_id")
	private String creditId;
	private int order;
	private String department;
	private String job;
	
}
