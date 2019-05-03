package com.muchmoretest.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muchmoretest.model.MovieTheater;
import com.muchmoretest.service.MovieTheaterService;
import com.muchmoretest.util.Utils;

@RestController
@RequestMapping("/movieTheater")
public class MovieTheaterController {
	
	@Autowired
	MovieTheaterService movieTheaterService;
	
	@GetMapping("/list")
	public List<MovieTheater> getMovieTheaters() {
		return movieTheaterService.findAll();
	}

	@GetMapping("/{id}")
	public Optional<MovieTheater> getById(@PathVariable ObjectId id) {
		return movieTheaterService.getById(id);
	}

	@PostMapping("/")
	public ResponseEntity<?> create(@Valid @RequestBody MovieTheater movieTheater) {
		if (movieTheaterService.existsByName(movieTheater.getName())) {
			return Utils.badRequest(false, "Este cinema já existe!");
		}
		
		movieTheaterService.create(movieTheater);

		return Utils.created(true, "Cinema criado com sucesso.");
	}

	@PutMapping("/")
	public ResponseEntity<?> update(@Valid @RequestBody MovieTheater movieTheater) {
		if (movieTheaterService.existsByNameAndIdNot(movieTheater.getName(), movieTheater.getId())) {
			return Utils.badRequest(false, "Este Cinema já existe!");
		}
		
		movieTheaterService.update(movieTheater);

		return Utils.created(true, "Cinema atualizado com sucesso.");
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") ObjectId id) {
		movieTheaterService.delete(id);

		return Utils.deleted(true, "Cinema deletado com sucesso.");
	}
	
}
