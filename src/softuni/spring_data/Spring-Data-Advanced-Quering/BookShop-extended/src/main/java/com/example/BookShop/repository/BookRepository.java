package com.example.BookShop.repository;

import com.example.BookShop.model.entity.AgeRestriction;
import com.example.BookShop.model.entity.Author;
import com.example.BookShop.model.entity.Book;
import com.example.BookShop.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName,
                                                                                      String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceBetween(BigDecimal lower, BigDecimal upper);

    //List<Book> findAllByPriceLessThenOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate lower, LocalDate upper);

    List<Book> findByTitleContains(String contStr);

    List<Book> findAllByAuthor_LastNameStartsWith(String startsWith);

    @Query("SELECT count(b) FROM Book b WHERE length(b.title) > :param")
    int countOfBooksWithTitleLengthMoreThan(@Param(value = "param") int titleLength);

    @Procedure("change_book_price_by_id")
    void changeBookPriceById(Long book_id);
}
