package com.laith.mongodb.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "authors")
public class Author {
    @Id
    private String id ;

    @NotEmpty
    private String name;

    @Email
    @Indexed(unique = true, name = "email", useGeneratedName = true)
    // this mens that we're going to use this field for search.
    private String email;

    @Indexed(unique = true)
    private String phone;


}
