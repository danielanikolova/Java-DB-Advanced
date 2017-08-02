package bookshop_system.services;


import bookshop_system.entities.Author;

import java.util.List;

public interface AuthorService<Author, Long> {

    void persist(Author author);

    Author findById(Long id);

    void remove(Author author);

    List<Author> findAll();

    List<Author> getAuthorsWithAtLeastOneBookAfter1990();

    List<Object[]> getAuthorByNumberOfOrderedBooks();

    List<Author> findAllByFirstNameEndsWith(String pattern);


    List<Object[]> findCopiesByAuthor();
}
