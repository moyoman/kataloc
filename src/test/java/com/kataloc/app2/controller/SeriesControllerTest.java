package com.kataloc.app2.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import com.kataloc.app2.entity.ProveedorPais;
import com.kataloc.app2.entity.Series;
import com.kataloc.app2.entity.SpokenLanguages;
import com.kataloc.app2.service.SerieService;

public class SeriesControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private SerieService serieService;
	
	@InjectMocks
	private SeriesController seriesController;
	
	@BeforeEach
	public void setUp() {
		
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(seriesController).build();
	}
	
	@Test
	void inserta_id_return_ok() throws Exception {
		
		Series s = new Series();
		s.setId(1);
		
		List<SpokenLanguages> paises = new ArrayList<SpokenLanguages>();
		ProveedorPais proveedor = new ProveedorPais();
		
		Mockito.when(serieService.getSerieById(1)).thenReturn(s);
		Mockito.when(serieService.getAllPaises()).thenReturn(paises);
		Mockito.when(serieService.getProveedores("", 1)).thenReturn(proveedor);
		
		this.mockMvc.perform(get("/serie/" + 1)).andExpect(status().isOk());
	}
}
