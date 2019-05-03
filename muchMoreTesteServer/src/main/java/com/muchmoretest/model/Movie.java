package com.muchmoretest.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe de Model da collection Filmes
 * @author Marconi Motta
 *
 */
@JsonIgnoreProperties
@Getter @Setter
@Document(collection="movie")
public class Movie {
	
	@NotNull
	private Long id;
	
	@NotNull
	private String title;
	
	@JsonAlias(value="overview")
	@NotNull
	private String description;
	
	@JsonAlias(value="original_title")
	@NotNull
	private String movie;
	
	@JsonAlias(value="genre_ids")
	private List<Integer> genres;
	
	@JsonAlias(value="release_date")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date year;
	

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}

}