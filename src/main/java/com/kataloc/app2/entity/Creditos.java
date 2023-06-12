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
public class Creditos {

	private int id;
	private List<Person> cast;
	private List<Person> crew;
}
