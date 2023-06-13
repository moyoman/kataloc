package com.kataloc.app2.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kataloc.app2.entity.Peliculas;
import com.kataloc.app2.entity.ProveedorPais;
import com.kataloc.app2.entity.SpokenLanguages;
import com.kataloc.app2.service.PeliculaService;

public class PeliculasControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private PeliculaService peliculaService;
	
	@InjectMocks
	private PeliculasController peliculasController;
	
	@BeforeEach
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(peliculasController).build();
	}
	
	@Test
	void inserta_id_return_ok() throws Exception {
		
		Peliculas p = new Peliculas();
		p.setId(1);
		List<SpokenLanguages> listaPaises = new ArrayList<SpokenLanguages>();
		ProveedorPais proveedor = new ProveedorPais();
		
		Mockito.when(peliculaService.getPeliculaById(1)).thenReturn(p);
		Mockito.when(peliculaService.getAllPaises()).thenReturn(listaPaises);
		Mockito.when(peliculaService.getProveedores("", 1)).thenReturn(proveedor);
		
		this.mockMvc.perform(get("/pelicula/" + 1)).andExpect(status().isOk());
	}
	
	@Test
	void inserta_id_and_pais_return_ok() throws Exception {
		
		Peliculas p = new Peliculas();
		p.setId(1);
		List<SpokenLanguages> listaPaises = new ArrayList<SpokenLanguages>();
		ProveedorPais proveedor = new ProveedorPais();
		
		Mockito.when(peliculaService.getPeliculaById(1)).thenReturn(p);
		Mockito.when(peliculaService.getAllPaises()).thenReturn(listaPaises);
		Mockito.when(peliculaService.getProveedores("", 1)).thenReturn(proveedor);
		
		this.mockMvc.perform(post("/pelicula/" + 1).param("pais", "")).andExpect(status().isOk());
	}
}
