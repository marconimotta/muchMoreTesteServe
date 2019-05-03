package com.muchmoretest.repository.genre;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.muchmoretest.model.Genre;

@Repository
public interface GenreRepository extends MongoRepository<Genre, ObjectId> {

}
