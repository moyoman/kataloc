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
import com.kataloc.app2.entity.Peliculas;
import com.kataloc.app2.entity.Person;
import com.kataloc.app2.entity.Populares;
import com.kataloc.app2.entity.ProveedorMedia;
import com.kataloc.app2.entity.ProveedorPais;
import com.kataloc.app2.entity.SpokenLanguages;

@Service
public class PeliculaService {

	private static String token = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI0MjhjYjdiYzFjZjE2MjQ0OWM3MzAwNjhhNzUwYjllMCIsInN1YiI6IjY0NmI3YzQ5MmJjZjY3MDBlM2JiY2ZlNCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.W9NVu2h4bun1GmHelZXudEWpijiTSYXAo8XFP9LJ0VA";
	private static String apiKeySearch = "?api_key=428cb7bc1cf162449c730068a750b9e0";
	private static String apiKeyQuery = "&api_key=428cb7bc1cf162449c730068a750b9e0";

	@Autowired
	private RestTemplate restTemplate;

	public List<Peliculas> getPrueba() {

		/*HttpRequest headers = HttpRequest.newBuilder()
				.uri(URI.create("https://api.themoviedb.org/3/authentication"))
				.header("accept", "application/json")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();*/

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity<Peliculas> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/movie/550" + apiKeySearch;

		List<Peliculas> lista = Arrays.asList(restTemplate.getForObject(url, Peliculas.class, entity));
		return lista;

	}

	public List<Peliculas> getPeliculaSearch(String search) {
		System.out.println(" Service " + search);
		String query = search.replaceAll(" ", "%");
		System.out.println(" Service " + query);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity<Populares> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/search/movie?query=" + query + "&language=en-US" + apiKeyQuery;

		Populares p = restTemplate.getForObject(url, Populares.class, entity);
		List<Peliculas> lista = p.getResults();

		return lista;
	}

	public Peliculas getPeliculaById(int id) {

		System.out.println("Llamada al service");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity<Peliculas> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/movie/" + id + apiKeySearch;
		Peliculas p = restTemplate.getForObject(url, Peliculas.class, entity);

		//p.setProveedores(getProveedores(id));

		url = "https://api.themoviedb.org/3/movie/" + p.getId() + "/credits" + apiKeySearch;
		Creditos c = restTemplate.getForObject(url, Creditos.class, entity);

		List<Person> cast = new ArrayList<Person>();
		List<Person> director = new ArrayList<Person>();
		List<Person> guion = new ArrayList<Person>();

		try {
			for(int i = 0; i < 5; i++) {
				cast.add(c.getCast().get(i));
			}
		} catch(IndexOutOfBoundsException e) {

		}

		for(Person aux: c.getCrew()) {
			if(aux.getJob().equalsIgnoreCase("director")) {
				director.add(aux);
			}
			if(aux.getJob().equalsIgnoreCase("screenplay") || aux.getJob().equalsIgnoreCase("writer")) {
				guion.add(aux);
			}
		}

		p.setTopCast(cast);
		p.setDirector(director);
		p.setGuionistas(guion);
		//p.setCredits(c);
		return p;
	}
	
	public Peliculas getPeliculaById(int id, String country) {

		System.out.println("Llamada al service");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.set("Authorization", token);

		HttpEntity<Peliculas> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/movie/" + id + apiKeySearch;
		Peliculas p = restTemplate.getForObject(url, Peliculas.class, entity);

		//p.setProveedores(getProveedores(id));

		url = "https://api.themoviedb.org/3/movie/" + p.getId() + "/credits" + apiKeySearch;
		Creditos c = restTemplate.getForObject(url, Creditos.class, entity);

		List<Person> cast = new ArrayList<Person>();
		List<Person> director = new ArrayList<Person>();
		List<Person> guion = new ArrayList<Person>();

		try {
			for(int i = 0; i < 5; i++) {
				cast.add(c.getCast().get(i));
			}
		} catch(IndexOutOfBoundsException e) {

		}

		for(Person aux: c.getCrew()) {
			if(aux.getJob().equalsIgnoreCase("director")) {
				director.add(aux);
			}
			if(aux.getJob().equalsIgnoreCase("screenplay") || aux.getJob().equalsIgnoreCase("writer")) {
				guion.add(aux);
			}
		}

		p.setTopCast(cast);
		p.setDirector(director);
		p.setGuionistas(guion);
		//p.setCredits(c);
		return p;
	}

	public List<Peliculas> getPopulares() {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		//headers.set("Authorization", token);

		HttpEntity<Populares> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/movie/popular" + apiKeySearch;

		Populares p = restTemplate.getForObject(url, Populares.class, entity);
		List<Peliculas> lista = p.getResults();

		/*for(Peliculas m: lista) {
			m.setProveedores(getProveedores(m.getId()));
		}*/
		return lista;		
	}

	public List<Peliculas> filterByGenero(String genre){

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<Populares> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/discover/movie?with_genres=" + genre + apiKeyQuery;

		Populares p = restTemplate.getForObject(url, Populares.class, entity);
		List<Peliculas> lista = p.getResults();

		/*for(Peliculas m: lista) {
			m.setProveedores(getProveedores(m.getId()));
		}*/
		return lista;
	}

	public HashMap<String, ProveedorPais> getAllProveedores(int id) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<ProveedorMedia> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/movie/" + id + "/watch/providers" + apiKeySearch;

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

		HttpEntity<GenresResult> entity = new HttpEntity<>(headers);
		String url = "https://api.themoviedb.org/3/genre/movie/list" + apiKeySearch;

		GenresResult result = restTemplate.getForObject(url, GenresResult.class, entity);
		List<Genres> generos = result.getGenres();

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
