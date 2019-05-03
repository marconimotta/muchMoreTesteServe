package com.muchmoretest.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
/**
 * Classe de Model da collection Gênero
 * @author Marconi Motta
 *
 */
@JsonIgnoreProperties
@Getter @Setter
@Document(collection="genre")
public class Genre {
	
	@Id
	private Integer id;
	
	private String name;
	
	@Transient
	private long count;

}
