package bookshop_system.entities;

import bookshop_system.entities.enumerations.AgeRestriction;
import bookshop_system.entities.enumerations.EditionType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {

    private Long id;
    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private Integer copies;
    private Date releaseDate;
    private AgeRestriction ageRestriction;
    private Author author;
    private Set<Book> relatedBooks;
    private Set<Category> categories;



    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length()<1 || title.length()>60){
            throw new IllegalArgumentException("Title should be between 1 and 50 symbols!");
        }
        this.title = title;
    }

    @Column(name = "description", columnDefinition = "text")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
//        if (description.length()>1000){
//            throw new IllegalArgumentException("Description should be up to 1000 symbols! ");
//        }
        this.description = description;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public EditionType getEditionType() {
        return editionType;
    }


    public void setEditionType(EditionType editionType) {

        this.editionType = editionType;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "copies", nullable = false)
    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }


    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public void setAgeRestriction(AgeRestriction ageRestriction) {

        this.ageRestriction = ageRestriction;
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "related_books",
    joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "related_id", referencedColumnName = "id"))
    public Set<Book> getRelatedBooks() {
        return relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }

    @ManyToMany
    @JoinTable(name = "books_categories",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    public Set<Category> getCategories() {
        return categories;
    }
    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
