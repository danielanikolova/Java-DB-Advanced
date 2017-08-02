package bookshop_system.repositories;

import bookshop_system.entities.Author;
import bookshop_system.entities.Book;
import bookshop_system.entities.enumerations.AgeRestriction;
import bookshop_system.entities.enumerations.EditionType;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{



    @Query("select b from Book as b where b.author.firstName = 'George' and b.author.lastName = 'Powell' " +
            "order by b.releaseDate desc, b.title asc ")
    List<Book> getBooksFromGeorgePowell();

    List<Book>findAllByAgeRestrictionIn(AgeRestriction restriction);

    @Query("select b from Book as b where b.editionType = 'GOLD' and b.copies<5000")
    List<Book>findAllByEditionTypeAndLessThanCopies();

    @Query("select b from Book as b where b.price<5 or b.price>40 ")
    List<Book>findAllByPriceNotBetween();


    @Query("select b from Book  as b where Year(b.releaseDate)!= :year")
    List<Book>findAllByReleaseDateNot(@Param("year") int year);


    @Query("select b from Book as b inner join b.categories as c where lower(c.name) in :categories")
    List<Book> findAllByCategoryIn(@Param("categories") List<String> categories);

    List<Book> findAllByReleaseDateBefore(Date date);


    List<Book> findAllByTitleContainingIgnoreCase(String pattern);


    List<Book> findAllByAuthorLastNameStartingWithIgnoreCase(String pattern);

    @Query("select b from Book as b where length(b.title) > :length ")
    List<Book> findAllByTitleIsGreaterThan(@Param("length") Integer length);


    @Query("select c.name, sum(b.copies*b.price) from Category as c inner join c.books as b " +
            "group by  c.name " +
            "order by sum(b.copies*b.price) desc, c.name asc")
    List<Object[]> findAllBooksAndTheirProfit();




}
