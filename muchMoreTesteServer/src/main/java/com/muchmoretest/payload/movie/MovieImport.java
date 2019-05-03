package com.muchmoretest.payload.movie;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.muchmoretest.model.Movie;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe criada para importação dos filmes baseado na api MovieDb
 * @author Marconi Motta
 *
 */
@JsonIgnoreProperties
@Getter @Setter
public class MovieImport {

	private List<Movie> results;
	private Integer total_results;
	
}
