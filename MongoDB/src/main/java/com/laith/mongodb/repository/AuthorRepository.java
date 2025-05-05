package com.laith.mongodb.repository;

import com.laith.mongodb.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {


    @Query(value= "{email:'?0'}")
    Author findAuthorByEmail (String email);
}
