package bookshop_system.services;


import bookshop_system.entities.Author;
import bookshop_system.entities.Book;
import bookshop_system.entities.enumerations.AgeRestriction;
import bookshop_system.entities.enumerations.EditionType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface BookService {
    void persist(Book book);

    List<Book> getAllBooks();


    List<Book> getBooksFromGeorgePowell();


    List<Book>findAllByAgeRestrictionIn(AgeRestriction restriction);

    List<Book>findAllByEditionTypeAndLessThanCopies();


    List<Book>findAllByPriceNotBetween();


    List<Book>findAllByReleaseDateNot(int year);

    List<Book> findAllByCategoryIn(List<String> categories);

    List<Book> findAllByReleaseDateBefore(Date date);

    List<Book> findAllByTitleContainingIgnoreCase(String pattern);

    List<Book> findAllByAuthorLastNameStartingWith(String pattern);

    List<Book> findAllByTitleIsGreaterThan(Integer length);

    List<Object[]> findAllBooksAndTheirProfit();


}
