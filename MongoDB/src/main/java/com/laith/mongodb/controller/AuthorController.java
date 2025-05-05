package com.laith.mongodb.controller;

import com.laith.mongodb.model.Author;
import com.laith.mongodb.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/author")
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService autherService) {
        super();
        this.authorService = autherService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {

        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {

        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody @Valid Author entity) {

        return ResponseEntity.ok(authorService.insert(entity));
    }

    @PutMapping("")
    public ResponseEntity<?> update(@RequestBody @Valid Author entity) {

        return ResponseEntity.ok(authorService.update(entity));
    }

    @GetMapping("/find-by-email/{email}")
    public ResponseEntity<?> findAuthorByEmail(@PathVariable @Email String email) {
        return ResponseEntity.ok(authorService.findAuthorByEmail(email));
    }

    @PutMapping("/custom")
    public ResponseEntity<?> updateEmail(@RequestParam @Email String email,
                                         @RequestParam String name,
                                         @RequestParam String phone) {
        authorService.updateEmail(email, name, phone);
        return ResponseEntity.ok(null);
    }

}
