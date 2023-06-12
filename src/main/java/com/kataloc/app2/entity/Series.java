package com.kataloc.app2.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
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
public class Series implements Serializable{

	private static final long serialVersionUID = 6089662252093425483L;
	
	private boolean adult;
	@JsonProperty("backdrop_path")
	private String backdropPath;
	@JsonProperty("created_by")
	private List<Person> createdBy;
	@JsonProperty("episode_run_time")
	private List<Integer> episodeRunTime;
	@JsonProperty("first_air_date")
	private String firstAirDate;
	@JsonAlias("genre_ids")
	private List<Genres> genres;
	private String homepage;
	private int id;
	@JsonProperty("in_production")
	private boolean inProduction;
	private List<String> languages;
	@JsonProperty("last_air_date")
	private String lastAirDate;
	@JsonProperty("last_episode_to_air")
	private Episodio lastEpisodeToAir;
	private String name;
	@JsonProperty("next_episode_to_air")
	private Episodio nextEpisodeToAir;
	//networks
	@JsonProperty("number_of_episodes")
	private int numberOfEpisodes;
	@JsonProperty("number_of_seasons")
	private int numberOfSeasons;
	@JsonProperty("origin_country")
	private List<String> originCountry;
	@JsonProperty("original_language")
	private String originalLanguage;
	@JsonProperty("original_name")
	private String originalName;
	private String overview;
	private int popularity;
	@JsonProperty("poster_path")
	private String posterPath;
	@JsonProperty("production_companies")
	private List<ProductionCompany> productionCompanies;
	//private List<ProductionCountries> productionCountries
	private List<Temporada> seasons;
	@JsonProperty("spoken_languages")
	private List<SpokenLanguages> spokenLanguages;
	private String status;
	private String tagline;
	private String type;
	@Setter(value = AccessLevel.NONE)
	@JsonProperty("vote_average")
	private int voteAverage;
	@JsonProperty("vote_count")
	private int voteCount;
	private ProveedorPais proveedores;
	
	private List<Person> topCast;
	
	public void setVoteAverage(int voteAverage) {
		this.voteAverage = voteAverage / 2;
	}
}
