package com.example.BookShop.service;

import com.example.BookShop.model.entity.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderedByCountOfTheirBooks();
}
