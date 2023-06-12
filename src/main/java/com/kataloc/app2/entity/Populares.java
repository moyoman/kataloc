package com.kataloc.app2.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Populares implements Serializable{

	private static final long serialVersionUID = -7378403705587558946L;
	
	private int page;
	private List<Peliculas> results;
}
