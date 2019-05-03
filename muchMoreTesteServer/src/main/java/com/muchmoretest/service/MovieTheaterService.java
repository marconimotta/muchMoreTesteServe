package com.muchmoretest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muchmoretest.exception.ResourceNotFoundException;
import com.muchmoretest.model.MovieTheater;
import com.muchmoretest.repository.movietheater.MovieTheaterRepository;

@Service
public class MovieTheaterService {
	
	@Autowired
	MovieTheaterRepository movieTheaterRepository;
	
	public boolean existsByName(String name) {
		return movieTheaterRepository.existsByName(name);
	}
	
	public boolean existsByNameAndIdNot(String name, ObjectId id) {
		return movieTheaterRepository.existsByNameAndIdNot(name, id);
	}
	
	public void create(MovieTheater movieTheater) {
		movieTheater.setCreatedAt(new Date());
		movieTheater.setUpdatedAt(new Date());
		movieTheaterRepository.save(movieTheater);
	}
	
	public void update(MovieTheater movieTheater) {
		MovieTheater movieTheaterToUpdate = movieTheaterRepository.findById(movieTheater.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Cinema", "id", movieTheater.getId()));
		movieTheaterToUpdate.setUpdatedAt(new Date());
		movieTheaterToUpdate.setAddress(movieTheater.getAddress());
		movieTheaterToUpdate.setName(movieTheater.getName());
		movieTheaterToUpdate.setMovies(movieTheater.getMovies());
		movieTheaterRepository.save(movieTheater);
	}
	
	public void delete(ObjectId id) {
		movieTheaterRepository.deleteById(id);
	}
	
	public Optional<MovieTheater> getById(ObjectId id) {
		return movieTheaterRepository.findById(id);
	}
	
	public List<MovieTheater> findAll(){
		return movieTheaterRepository.findAll();
	}

}
