package com.kataloc.app2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kataloc.app2.entity.Peliculas;
import com.kataloc.app2.service.PeliculaService;

@RestController
public class PeliculasController {

	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/pelicula/{id}")
	public ModelAndView getPelicula(@PathVariable int id) {

		System.out.println("/pelicula/" + id);
		Peliculas pelicula = peliculaService.getPeliculaById(id);
		System.out.println(pelicula.getVoteAverage());
		ModelAndView mav = new ModelAndView("descripcion-pelicula");
		mav.addObject("pelicula" ,pelicula);
		mav.addObject("countries", peliculaService.getAllPaises());
		mav.addObject("proveedores", peliculaService.getProveedores("ES", id));
		return mav;
	}
	
	@PostMapping("/pelicula/{id}")
	public ModelAndView getPeliculaProveedor(@PathVariable int id, @RequestParam String pais) {

		System.out.println("pais: " + pais);
		Peliculas pelicula = peliculaService.getPeliculaById(id);
		ModelAndView mav = new ModelAndView("descripcion-pelicula");
		mav.addObject("pelicula" ,pelicula);
		mav.addObject("countries", peliculaService.getAllPaises());
		mav.addObject("proveedores", peliculaService.getProveedores(pais, id));
		return mav;
	}
	
	@PostMapping("/searchPelicula")
	public ModelAndView getSearchMovie(@RequestParam String search) {
		
		System.out.println(search);
		ModelAndView mav = new ModelAndView("resultados-peliculas");
		mav.addObject("search" ,peliculaService.getPeliculaSearch(search));
		return mav;
	}
	
	@GetMapping("/peliculas")
	public ModelAndView getPelicula() {
		
		ModelAndView mav = new ModelAndView("pelicula");
		mav.addObject("peliculas", peliculaService.getPopulares());
		mav.addObject("generos", peliculaService.getGeneros());
		return mav;
	}
	
	@PostMapping("/peliculas")
	public ModelAndView filtro(@RequestParam String generos) {

		ModelAndView mav = new ModelAndView("pelicula");
		mav.addObject("peliculas", peliculaService.filterByGenero(generos));
		mav.addObject("generos", peliculaService.getGeneros());
		return mav;
		
	}
}
