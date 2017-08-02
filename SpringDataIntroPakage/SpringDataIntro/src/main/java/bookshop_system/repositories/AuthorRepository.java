package bookshop_system.repositories;

import bookshop_system.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {


    @Query("select a from Author as a join a.books as b where YEAR(b.releaseDate) < 1990")
    List<Author> getAuthorsWithAtLeastOneBookAfter1990();

    @Query("select a.firstName, a.lastName, count(*) as book_count from Author as a inner join a.books " +
            "group by a.firstName, a.lastName order by book_count desc")
    List<Object[]> getAuthorByNumberOfOrderedBooks();

    List<Author> findAllByFirstNameEndsWith(String pattern);


    @Query("select a.firstName, a.lastName, sum(b.copies) from Author as a " +
            "inner join a.books as b group by a.firstName, a.lastName " +
            "order by sum (b.copies) desc ")
    List<Object[]> findCopiesByAuthor();




}
