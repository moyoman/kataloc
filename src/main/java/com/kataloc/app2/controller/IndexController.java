package com.kataloc.app2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kataloc.app2.service.PeliculaService;
import com.kataloc.app2.service.SerieService;

@RestController
public class IndexController {

	@Autowired
	private PeliculaService peliculaService;
	
	@Autowired
	private SerieService serieService;
	
	@GetMapping("")
	public ModelAndView getPopular() {
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("peliculas", peliculaService.getPopulares());
		mav.addObject("series", serieService.getPopulares());
		return mav;
	}
}
