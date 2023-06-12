package com.kataloc.app2.entity;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorMedia {

	private int id;
	HashMap<String, ProveedorPais> results;
}
