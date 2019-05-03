package com.muchmoretest.repository.movietheater;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.muchmoretest.model.MovieTheater;

@Repository
public interface MovieTheaterRepository extends MongoRepository<MovieTheater, ObjectId> {
	
	public boolean existsByName(String name);
	
	public boolean existsByNameAndIdNot(String name, ObjectId id);

}
