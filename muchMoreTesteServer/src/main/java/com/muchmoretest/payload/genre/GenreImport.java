package com.muchmoretest.payload.genre;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.muchmoretest.model.Genre;

import lombok.Getter;
import lombok.Setter;

/**
 * Classe criada para importação do Gêneros baseado na api MovieDb
 * @author Marconi Motta
 *
 */
@JsonIgnoreProperties
@Getter @Setter
public class GenreImport {
	
	@JsonAlias(value="genres")
	List<Genre> results;

}
