package com.kataloc.app2.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Peliculas implements Serializable{

	private static final long serialVersionUID = 7877450639698080739L;
	
	//private String _id;
	private boolean adult;
	@JsonProperty("backdrop_path")
	private String backdropPath;
	@JsonProperty("belongs_to_collection")
	private ColleccionPeliculas belongsToCollection;
	private long budget;
	private List<Genres> genres;
	private String homepage;
	private int id;
	@JsonProperty("imdb_id")
	private String imdbId;
	@JsonProperty("original_language")
	private String originalLanguage;
	@JsonProperty("original_title")
	private String originalTitle;
	private String overview;
	private int popularity;
	@JsonProperty("poster_path")
	private String posterPath;
	@JsonProperty("production_companies")
	private List<ProductionCompany> productionCompanies;
	@JsonProperty("release_date")
	private String releaseDate;
	private long revenue;
	private int runtime;
	@JsonProperty("spoken_languages")
	private List<SpokenLanguages> spokenLanguages;
	private String status;
	private String tagline;
	private String title;
	private boolean video;
	@JsonProperty("vote_average")
	@Setter(value = AccessLevel.NONE)
	private int voteAverage;
	@JsonProperty("vote_count")
	private int voteCount;
	@JsonIgnoreProperties(ignoreUnknown = true)
	private ProveedorPais proveedores;
	
	private List<Person> topCast;
	private List<Person> director;
	private List<Person> guionistas;
	
	public void setVoteAverage(int voteAverage) {
		this.voteAverage = voteAverage / 2;
	}
	
	
	 
}
