package com.example.BookShop.service;

import com.example.BookShop.model.entity.AgeRestriction;
import com.example.BookShop.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;
    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBookTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldBooksWithCopiesLessThan5000();

    List<String> findAllBooksTitlesWithPriceLessThan5OrMoreThan40();

    List<String> findNotReleasedBookTitlesInYear(int year);

    List<String> findAllBooksBeforeDate(LocalDate localDate);
}
