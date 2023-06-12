package com.kataloc.app2.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorPais {

	private String link;
	private List<Proveedor> flatrate;
	private List<Proveedor> rent;
	private List<Proveedor> buy;
}
