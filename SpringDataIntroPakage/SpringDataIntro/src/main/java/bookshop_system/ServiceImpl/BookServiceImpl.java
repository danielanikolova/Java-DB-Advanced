package bookshop_system.ServiceImpl;


import bookshop_system.entities.Author;
import bookshop_system.entities.Book;
import bookshop_system.entities.enumerations.AgeRestriction;
import bookshop_system.entities.enumerations.EditionType;
import bookshop_system.repositories.BookRepository;
import bookshop_system.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }



    @Override
    public void persist(Book book) {
        this.bookRepository.save(book);

    }


    @Override
    public List<Book> getAllBooks() {

        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksFromGeorgePowell() {
        return this.bookRepository.getBooksFromGeorgePowell();
    }


    @Override
    public List<Book>findAllByAgeRestrictionIn(AgeRestriction restriction){
        return this.bookRepository.findAllByAgeRestrictionIn(restriction);
    }

    @Override
    public List<Book>findAllByEditionTypeAndLessThanCopies(){
        return this.bookRepository.findAllByEditionTypeAndLessThanCopies();
    }

    @Override
    public List<Book>findAllByPriceNotBetween(){
        return  this.bookRepository.findAllByPriceNotBetween();
    }

    @Override
    public List<Book>findAllByReleaseDateNot(int year){
        return this.bookRepository.findAllByReleaseDateNot(year);
    }


    @Override
    public List<Book> findAllByCategoryIn(List<String> categories){
        return this.bookRepository.findAllByCategoryIn(categories);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(Date date){
        return this.bookRepository.findAllByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findAllByTitleContainingIgnoreCase(String pattern){
        return  this.bookRepository.findAllByTitleContainingIgnoreCase(pattern);
    }

    @Override
    public List<Book> findAllByAuthorLastNameStartingWith(String pattern){
        return this.bookRepository.findAllByAuthorLastNameStartingWithIgnoreCase(pattern);
    }

    @Override
    public List<Book> findAllByTitleIsGreaterThan(Integer length){
        return this.bookRepository.findAllByTitleIsGreaterThan(length);
    }

    @Override
    public List<Object[]> findAllBooksAndTheirProfit(){
        return this.bookRepository.findAllBooksAndTheirProfit();
    }




}
