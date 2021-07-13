package com.example.BookShop;

import com.example.BookShop.model.entity.AgeRestriction;
import com.example.BookShop.model.entity.Book;
import com.example.BookShop.service.AuthorService;
import com.example.BookShop.service.BookService;
import com.example.BookShop.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();
        //printAllBooksAfterYear(2000);
        //printAllAuthorNamesWithBooksWithReleaseDateBeforeYear(1990);
        //printAllAuthorsAndNumberOfTheirBooks();
        //printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Please enter exercise number:");
        int exNumber = Integer.parseInt(bufferedReader.readLine());

        switch (exNumber) {
            case 1: bookTitlesByAgeRestriction();
            case 2: goldenBook();
            case 3: bookByPrice();
            case 4: notReleasedBooks();
            case 5: booksReleasedBeforeDate();
            case 6: authorsSearch();
        }
    }

    // exercise 1;
    private void bookTitlesByAgeRestriction() throws IOException {
        System.out.println("Please enter age restriction:");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        bookService.findAllBookTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    // exercise 2;
    private void goldenBook() {
        bookService.findAllGoldBooksWithCopiesLessThan5000()
                .forEach(System.out::println);
    }

    // exercise 3;
    private void bookByPrice() {
    bookService.findAllBooksTitlesWithPriceLessThan5OrMoreThan40()
            .forEach(System.out::println);
    }

    // exercise 4;
    private void notReleasedBooks() throws IOException {
        System.out.println("Please enter year:");
        int year = Integer.parseInt(bufferedReader.readLine());

        bookService.findNotReleasedBookTitlesInYear(year)
                .forEach(System.out::println);
    }

    // exercise 5;
    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Please enter date in format dd-MM-yyyy:");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService.findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    // exercise 6;
    private void authorsSearch() throws IOException {
        System.out.println("Please enter first name ends with /string/:");
        String endStr = bufferedReader.readLine();

        authorService.findAuthorFirstNameEndsWithStr(endStr)
                .forEach(System.out::println);
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService.findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {

        authorService.getAllAuthorsOrderedByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService.findAllAuthorWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);

    }

    private void printAllBooksAfterYear(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

    }
}
