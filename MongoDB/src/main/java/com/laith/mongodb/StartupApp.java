package com.laith.mongodb;

import com.laith.mongodb.model.Author;
import com.laith.mongodb.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@EnableMongoRepositories
public class StartupApp  implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepo;

    @Override
    public void run(String... args) throws Exception {
        if(authorRepo.findAll().isEmpty()) {
            Author author = new Author();
            author.setName("Mohamed");
            author.setEmail("moh@gmail.com");
            author.setPhone("012254254");

            Author author1 = new Author();
            author1.setName("Ali");
            author1.setEmail("ali@gmail.com");
            author1.setPhone("0155254254");

            Author author2 = new Author();
            author2.setName("Omer");
            author2.setEmail("omer@gmail.com");
            author2.setPhone("015555524");

            authorRepo.insert(Arrays.asList(author, author1, author2));
        }
    }
}
