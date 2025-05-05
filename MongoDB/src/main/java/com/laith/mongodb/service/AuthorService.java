package com.laith.mongodb.service;

import com.laith.mongodb.model.Author;
import com.laith.mongodb.repository.AuthorRepository;
import com.laith.mongodb.repository.ICustomAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ICustomAuthorRepository customAuthorRepository;


    public Author findById(String id) {

        return authorRepository.findById(id).get();
    }

    public List<Author> findAll() {

        return authorRepository.findAll();
    }

    public Author insert(Author entity) {

        if (entity.getId() != null) {

            throw new RuntimeException();
        }

        return authorRepository.insert(entity);
    }

    public List<Author> insertAll(List<Author> entity) {

        return authorRepository.saveAll(entity);
    }

    public Author update(Author entity) {

        Author author = findById(entity.getId());
        author.setName(entity.getName());
        author.setEmail(entity.getEmail());
        author.setPhone(entity.getPhone());

        return authorRepository.save(author);
    }
    public Author findAuthorByEmail (String email) {
        return authorRepository.findAuthorByEmail(email);
    }

    public void updateEmail(String email, String name , String phone) {
        customAuthorRepository.updateEmail(email, name, phone);
    }



}
