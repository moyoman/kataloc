package com.kataloc.app2.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Genres implements Serializable {

	private static final long serialVersionUID = 1823409839171684775L;
	
	private int id;
	private String name;
	
	public Genres(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Genres [id=" + id + ", name=" + name + "]";
	}
}
