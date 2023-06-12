package com.kataloc.app2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kataloc.app2.entity.Series;
import com.kataloc.app2.service.SerieService;

@RestController
public class SeriesController {

	@Autowired
	private SerieService serieService;
	
	@GetMapping("/series/popular")
	private ResponseEntity<List<Series>> getPopular(){
		
		return ResponseEntity.ok().body(serieService.getPopulares());
	}
	
	@GetMapping("/serie/{id}")
	public ModelAndView getSearchSeries(@PathVariable int id) {
		
		ModelAndView mav = new ModelAndView("descripcion-serie");
		mav.addObject("serie", serieService.getSerieById(id));
		mav.addObject("countries", serieService.getAllPaises());
		mav.addObject("proveedores", serieService.getProveedores("ES", id));
		return mav;
		
	}
	
	@PostMapping("/serie/{id}")
	public ModelAndView getSerieProveedor(@PathVariable int id, @RequestParam String pais) {
		
		ModelAndView mav = new ModelAndView("descripcion-serie");
		mav.addObject("serie", serieService.getSerieById(id));
		mav.addObject("countries", serieService.getAllPaises());
		mav.addObject("proveedores", serieService.getProveedores(pais, id));
		return mav;
	}
	
	@PostMapping("/searchSerie")
	public ModelAndView getSearchSerie(@RequestParam String search) {
		
		ModelAndView mav = new ModelAndView("resultados-series");
		mav.addObject("search", serieService.getSerieSearch(search));
		return mav;
	}
	
	@GetMapping("/series")
	public ModelAndView getSerie() {
		
		ModelAndView mav = new ModelAndView("serie");
		mav.addObject("series", serieService.getPopulares());
		mav.addObject("generos", serieService.getGeneros());
		return mav;
	}
	
	@GetMapping("/series/{pag}")
	public ModelAndView getPaginaSerie(@PathVariable int pag) {

		ModelAndView mav = new ModelAndView("serie");
		mav.addObject("series", serieService.getPopularesPag(pag));
		mav.addObject("generos", serieService.getGeneros());
		return mav;
	}
	
	@PostMapping("/series")
	public ModelAndView filtro(@RequestParam String generos) {
		
		ModelAndView mav = new ModelAndView("serie");
		mav.addObject("series", serieService.filterByGenero(generos));
		mav.addObject("generos", serieService.getGeneros());
		return mav;
	}
}
