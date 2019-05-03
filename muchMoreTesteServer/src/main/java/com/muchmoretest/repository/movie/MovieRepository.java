package com.muchmoretest.repository.movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.muchmoretest.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {
	
	public long countByGenres(Integer id);

}
