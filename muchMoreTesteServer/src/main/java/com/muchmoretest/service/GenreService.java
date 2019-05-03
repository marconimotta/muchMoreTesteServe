package com.muchmoretest.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muchmoretest.model.Genre;
import com.muchmoretest.payload.genre.GenreImport;
import com.muchmoretest.repository.genre.GenreRepository;
import com.muchmoretest.repository.movie.MovieRepository;
import com.muchmoretest.util.Utils;

@Service
public class GenreService {
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	public void importGenres() {
		GenreImport genres = Utils.getExternalService("/genre/movie/list?api_key=738887c441178634b4f3c49a8b776d16", GenreImport.class);
		if(Objects.nonNull(genres) && Objects.nonNull(genres.getResults()) && !genres.getResults().isEmpty()) {
			genreRepository.deleteAll();
			genreRepository.saveAll(genres.getResults());
		}
	}
	
	public List<Genre> listGenresWithCountNowPlaying(){
		 List<Genre> genres = genreRepository.findAll();
		 if(Objects.nonNull(genres) && !genres.isEmpty()) {
			 genres.stream().forEach(genre -> genre.setCount(movieRepository.countByGenres(genre.getId())));
		 }
		 return genres;
	}

}
