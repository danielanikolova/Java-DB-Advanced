package bookshop_system.ServiceImpl;


import bookshop_system.entities.Author;
import bookshop_system.repositories.AuthorRepository;
import bookshop_system.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;



@Service
@Transactional
public class AuthorServiceImpl implements AuthorService<Author, Long>{

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {

        this.authorRepository = authorRepository;
    }

    @Override
    public void persist(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public Author findById(Long id) {
        return this.authorRepository.findOne(id);
    }

    @Override
    public void remove(Author author) {

        this.authorRepository.delete(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public List<Author> getAuthorsWithAtLeastOneBookAfter1990() {
        return this.authorRepository.getAuthorsWithAtLeastOneBookAfter1990();
    }

    @Override
    public List<Object[]> getAuthorByNumberOfOrderedBooks() {
        return this.authorRepository.getAuthorByNumberOfOrderedBooks();
    }

    @Override
    public List<Author> findAllByFirstNameEndsWith(String pattern){
        return this.authorRepository.findAllByFirstNameEndsWith(pattern);
    }


    @Override
    public List<Object[]> findCopiesByAuthor() {
        return this.authorRepository.findCopiesByAuthor();
    }
}
