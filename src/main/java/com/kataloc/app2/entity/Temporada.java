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
public class Temporada {

	@JsonProperty("_id")
	private String uid;
	@JsonProperty("air_date")
	private String airDate;
	@JsonProperty("episode_count")
	private int episodeCount;
	private List<Episodio> episodes;
	private String name;
	private String overview;
	private int id;
	@JsonProperty("poster_path")
	private String posterPath;
	@JsonProperty("season_number")
	private int seasonNumber;
}
