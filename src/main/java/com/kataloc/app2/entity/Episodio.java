package com.kataloc.app2.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Episodio {

	@JsonProperty("air_date")
	private String airDate;
	private List<Person> crew;
	@JsonProperty("episode_number")
	private int episodeNumber;
	//private x guestStars;
	private String name;
	private String overview;
	private int id;
	@JsonProperty("production_code")
	private String productionCode;
	private int runtime;
	@JsonProperty("season_number")
	private int seasonNumber;
	@JsonProperty("still_path")
	private String stillPath;
	@JsonProperty("vote_average")
	private int voteAverage;
	@JsonProperty("vote_count")
	private int voteCount;
}
