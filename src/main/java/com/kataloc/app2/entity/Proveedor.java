package com.kataloc.app2.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Proveedor {

	@JsonProperty("logo_path")
	private String logoPath;
	@JsonProperty("provider_id")
	private int id;
	@JsonProperty("provider_name")
	private String name;
	@JsonProperty("display_priority")
	private String displayPriority;
	
}
