package com.muchmoretest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muchmoretest.model.Genre;
import com.muchmoretest.service.GenreService;
import com.muchmoretest.util.Utils;

@RestController
@RequestMapping("/genre")
public class GenreController {
	
	@Autowired
	GenreService genreService;
	
	@PostMapping("/import")
	public ResponseEntity<?> importGenres() {
		genreService.importGenres();
		return Utils.created(true, "Gêneros importados com sucesso.");
	}
	
	@GetMapping("/list/count/nowPlaying")
	public List<Genre> GenresWithCountNowPlaying(){
		return genreService.listGenresWithCountNowPlaying();
	}

}
