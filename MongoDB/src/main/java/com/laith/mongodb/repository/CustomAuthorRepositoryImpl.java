package com.laith.mongodb.repository;

import com.laith.mongodb.model.Author;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import org.springframework.stereotype.Component;

@Component
public class CustomAuthorRepositoryImpl implements ICustomAuthorRepository{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateEmail(String email, String name, String phone) {
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update();
        update.set("name", name);
        update.set("phone", phone);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Author.class);

        if(result == null)
            System.out.println("There is no documents updated");
        else
            System.out.println(result.getModifiedCount() + " document(s) has been updated successfully..");
    }

}
