package com.kataloc.app2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.kataloc.app2.entity.Creditos;
import com.kataloc.app2.entity.Genres;
import com.kataloc.app2.entity.GenresResult;
import com.kataloc.app2.entity.Person;
import com.kataloc.app2.entity.PopularesSeries;
import com.kataloc.app2.entity.ProveedorMedia;
import com.kataloc.app2.entity.ProveedorPais;
import com.kataloc.app2.entity.Series;
import com.kataloc.app2.entity.SpokenLanguages;

@Service
public class SerieService {

	//private static String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MjhjYjdiYzFjZjE2MjQ0OWM3MzAwNjhhNzUwYjllMCIsInN1YiI6IjY0NmI3YzQ5MmJjZjY3MDBlM2JiY2ZlNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.W9NVu2h4bun1GmHelZXudEWpijiTSYXAo8XFP9LJ0VA";
	private static String apiKeySearch = "?api_key=428cb7bc1cf162449c730068a750b9e0";
	private static String apiKeyQuery = "&api_key=428cb7bc1cf162449c730068a750b9e0";

	@Autowired
	private RestTemplate restTemplate;

	public Series getSerieById(int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Series> entity = new HttpEntity<Series>(headers);
		String url = "https://api.themoviedb.org/3/tv/" + id + apiKeySearch;

		Series s = restTemplate.getForObject(url, Series.class, entity);
		
		url = "https://api.themoviedb.org/3/tv/" + s.getId() + "/credits" + apiKeySearch;
		Creditos c = restTemplate.getForObject(url, Creditos.class, entity);
		
		List<Person> topCast = new ArrayList<Person>();
		
		try {
			for(int i = 0; i < 5; i++) {
				topCast.add(c.getCast().get(i));
			}
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		s.setTopCast(topCast);
		return s;
	}
	
	public List<Series> getSerieSearch(String search) {
		
		String query = search.replaceAll(" ", "%");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Series> entity = new HttpEntity<Series>(headers);
		String url = "https://api.themoviedb.org/3/search/tv?query="  + query + "&language=en-US" + apiKeyQuery;
		
		PopularesSeries pS = restTemplate.getForObject(url, PopularesSeries.class, entity);
		List<Series> s = pS.getResults();
		return s;
	}

	public List<Series> getPopulares(){

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Series> entity = new HttpEntity<Series>(headers);
		String url = "https://api.themoviedb.org/3/tv/popular" + apiKeySearch;

		PopularesSeries ps = restTemplate.getForObject(url, PopularesSeries.class, entity);
		List<Series> lista = ps.getResults();

		return lista;
	}
	
	public List<Series> filterByGenero(String genre){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Series> entity = new HttpEntity<Series>(headers);
		String url = "https://api.themoviedb.org/3/discover/tv?with_genres=" + genre + apiKeyQuery;

		PopularesSeries ps = restTemplate.getForObject(url, PopularesSeries.class, entity);
		List<Series> lista = ps.getResults();

		return lista;
	}
	
	public List<Series> getPopularesPag(int pag){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<Series> entity = new HttpEntity<Series>(headers);
		String url = "https://api.themoviedb.org/3/tv/popular?page=" + pag + apiKeyQuery;
		System.out.println(url);

		PopularesSeries ps = restTemplate.getForObject(url, PopularesSeries.class, entity);
		List<Series> lista = ps.getResults();

		return lista;
	}
	
	public HashMap<String, ProveedorPais> getAllProveedores(int id) {

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

	    HttpEntity<ProveedorMedia> entity = new HttpEntity<>(headers);
	    String url = "https://api.themoviedb.org/3/tv/" + id + "/watch/providers" + apiKeySearch;

	    ProveedorMedia pm = restTemplate.getForObject(url, ProveedorMedia.class, entity);
	    HashMap<String, ProveedorPais> proveedores = pm.getResults();
	    return proveedores;
	}

	public ProveedorPais getProveedores(String pais, int id) {
			
	    ProveedorPais proveedores = getAllProveedores(id).get(pais);
	    return proveedores;
	}

	public List<Genres> getGeneros() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<GenresResult> entity = new HttpEntity<GenresResult>(headers);
		String url = "https://api.themoviedb.org/3/genre/tv/list" + apiKeySearch;
		
		GenresResult gR = restTemplate.getForObject(url, GenresResult.class, entity);
		List<Genres> generos = gR.getGenres();
		
		return generos;
	}
	
	public List<SpokenLanguages> getAllPaises() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<SpokenLanguages> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/configuration/countries" + apiKeySearch;

		return Arrays.asList(restTemplate.getForObject(url, SpokenLanguages[].class, entity));
	}
}
