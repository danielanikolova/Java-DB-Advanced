package bookshop_system.terminal;

import bookshop_system.entities.Author;
import bookshop_system.entities.Book;
import bookshop_system.entities.Category;
import bookshop_system.entities.enumerations.AgeRestriction;
import bookshop_system.entities.enumerations.EditionType;
import bookshop_system.services.AuthorService;
import bookshop_system.services.BookService;
import bookshop_system.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


@Component
public class ConsoleRunner implements CommandLineRunner {


    private final BookService bookService;

    private final CategoryService categoryService;

    private final AuthorService authorService;

    @Autowired
    public ConsoleRunner(BookService bookService, CategoryService categoryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;

    }

    Random random = new Random();

    @Override
    public void run(String... strings) throws Exception {

        //Seed Database
     // seedDatabase();


        //Exercises from Spring Data Advanced Querying

        Scanner scanner = new Scanner(System.in);

        //1.Age Restriction

//
//
//        String inputAgeRestriction = scanner.nextLine().toUpperCase();
//
//        AgeRestriction currentRestriction = AgeRestriction.valueOf(inputAgeRestriction);
//
//        List<Book> booksWithRestriction = this.bookService
//                .findAllByAgeRestrictionIn(currentRestriction);
//
//        for (Book book : booksWithRestriction) {
//            System.out.println(book.getTitle());
//        }

        //2.Golden Books



//       List<Book> booksByEditionType= this.bookService.findAllByEditionTypeAndLessThanCopies();
//
//
//        for (Book book:booksByEditionType) {
//            System.out.println(book.getTitle());
//        }


        //3. Books by Price

//      List<Book> booksWithPrice = this.bookService.findAllByPriceNotBetween();
//
//        for (Book book: booksWithPrice) {
//            System.out.printf("%s - %s\n", book.getTitle(), book.getPrice());
//        }

        //4. Not Released Books

//        int releasedYear = scanner.nextInt();
//
//        List<Book> notReleasedBooks = this.bookService.findAllByReleaseDateNot(releasedYear);
//
//        for (Book book:notReleasedBooks) {
//            System.out.println(book.getTitle());
//        }


        //5. Book Titles by Category

       List<String> categories = Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+"));



        List<Book> booksByCategories = this.bookService.findAllByCategoryIn(categories);

        for (Book book: booksByCategories) {
            System.out.println(book.getTitle());
        }

        //6. Books Released Before Date

//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        Date releaseDate = sdf.parse(scanner.nextLine());
//
//        List<Book> booksBeforeDate = this.bookService.findAllByReleaseDateBefore(releaseDate);
//
//        for (Book book:booksBeforeDate) {
//
//            System.out.println(book.getTitle());
//        }


      //  7. Authors Search


//        String inputEnd = scanner.nextLine();
//
//        List<Author> authorsWithNamesThatEndsWith =
//                this.authorService.findAllByFirstNameEndsWith(inputEnd);
//
//        for (Author author:authorsWithNamesThatEndsWith) {
//
//            System.out.println(author.getFirstName()+ " " + author.getLastName());
//        }


       // 8. Books Search

//        String pattern = scanner.nextLine();
//
//        List<Book> booksContainingPattern =
//                this.bookService.findAllByTitleContainingIgnoreCase(pattern);
//
//        for (Book book:booksContainingPattern) {
//            System.out.println(book.getTitle());
//        }


        //9. Book Titles Search

//        String startingPattern = scanner.nextLine();
//
//        List<Book> searchedBooks = this.bookService.findAllByAuthorLastNameStartingWith(startingPattern);
//
//        for (Book book: searchedBooks) {
//            System.out.printf("%s - %s %s\n",
//                    book.getTitle(), book.getAuthor().getFirstName(), book.getAuthor().getLastName());
//        }


        //10. Count Books
//
//        int number = Integer.parseInt(scanner.nextLine());
//
//        List<Book> searchedBooks = this.bookService.findAllByTitleIsGreaterThan(number);
//
//        System.out.printf("There are %s books", searchedBooks.size());

        //11. Total Book Copies

//        List<Object[]> searchedAuthors = this.authorService.findCopiesByAuthor();
//
//        for (Object[] author: searchedAuthors) {
//            System.out.printf("%s %s - %s\n",author[0], author[1], author[2] );
//        }

       // 12. Find Profit

//        List<Object[]> bookProfits = this.bookService.findAllBooksAndTheirProfit();
//
//        for (Object[] profit: bookProfits ) {
//            System.out.printf("%s - $%s\n", profit[0], profit[1] );
//        }


        //13. Most recent book

//        Calendar calendar = Calendar.getInstance();
//
//        List<Category> categoriesByBookCount = this.categoryService.findAllCategoriesOrderByBookCount();
//        categoriesByBookCount.forEach(c -> {
//            System.out.println(String.format("--%s: %d books",
//                    c.getName(),
//                    c.getBooks().size()));
//            c.getBooks().stream()
//                    .sorted((b1, b2) -> {
//                        int result = b2.getReleaseDate().compareTo(b1.getReleaseDate());
//                        if (result == 0) {
//                            result = b1.getTitle().compareTo(b2.getTitle());
//                        }
//
//                        return result;
//                    })
//                    .limit(3)
//                    .forEach(b -> {
//                        calendar.setTime(b.getReleaseDate());
//                        System.out.println(String.format("%s - (%s)",
//                            b.getTitle(),
//                            calendar.get(Calendar.YEAR)));
//                    });
//        });



        //14 Reduced Book


        //Exercises from Spring Data Intro

       //Get all books after the year 2000.
//        List<Book>books = this.bookService.getAllBooks();
//
//        Calendar calendar = Calendar.getInstance();
//
//        for (Book book:books) {
//
//            calendar.setTime(book.getReleaseDate());
//            int year = calendar.get(Calendar.YEAR);
//
//            if (year>2000){
//                System.out.println(book.getTitle());
//            }
//
//        }

        //print authors with at least one book with release date after 1990;


//        List<Author> authors = authorService.getAuthorsWithAtLeastOneBookAfter1990();
//
//        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));


        //Authors by number of their ordered books

//        List<Object[]> authorsAndOrderedBooks = authorService.getAuthorByNumberOfOrderedBooks();
//
//        authorsAndOrderedBooks.stream().forEach(a-> System.out.printf("%s %s - %s books\n",
//                a[0], a[1], a[2] ));


        //Books from George Powell

//        List<Book> books = bookService.getBooksFromGeorgePowell();
//        books.forEach(b -> System.out.printf("Title: %s, Release date: %s, Copies: %d\n",
//                b.getTitle(),
//                b.getReleaseDate(),
//                b.getCopies()));



        //Related Books

//     List<Book> booksToRelate = bookService.getAllBooks().subList(4,7);
//
//     List<Book> books = bookService.getAllBooks();
//
//        for (Book book:booksToRelate) {
//
//            int firstBookIndex = random.nextInt(books.size());
//            book.getRelatedBooks().addAll(books.subList(firstBookIndex, firstBookIndex +15));
//            this.bookService.persist(book);
//        }
//
//
//        for (Book book:booksToRelate) {
//            System.out.printf("Book: %s\n",book.getTitle());
//            book.getRelatedBooks().stream().forEach(s->
//                    System.out.printf("---%s\n",s.getTitle())
//            );
//        }

    }



    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = this.seedAuthors();
        List<Category> categories = this.seedCategories();
        this.seedBooks(authors, categories);

    }

    private List<Author> seedAuthors() throws FileNotFoundException, IOException {

        BufferedReader authorReader = new BufferedReader(new FileReader
                ("C:target\\resourcesFiles\\authors.txt"));
        String authorsLine = authorReader.readLine();
        List<Author> authors = new LinkedList<>();

        while (authorsLine!= null) {
            String[] authorData = authorsLine.split("\\s");
            Author author = new Author();
            author.setFirstName(authorData[0]);
            author.setLastName(authorData[1]);
            authors.add(author);

            authorService.persist(author);

            authorsLine = authorReader.readLine();

        }
        return authors;
    }

    private List<Category> seedCategories() throws FileNotFoundException, IOException {

        BufferedReader categoriesReader = new BufferedReader(new FileReader("target\\resourcesFiles\\categories.txt"));
        String categoriesLine = categoriesReader.readLine();
        List<Category> categories = new ArrayList<>();
        while (categoriesLine != null) {
            String[] categoryData = categoriesLine.split("\\s");
            Category category = new Category();
            category.setName(categoryData[0]);
            categories.add(category);

            categoryService.persist(category);

            categoriesLine = categoriesReader.readLine();
        }
        return categories;
    }

    private void seedBooks(List<Author> authors, List<Category> categories)
            throws ParseException, IOException {

        BufferedReader booksReader = new BufferedReader(new FileReader("target\\resourcesFiles\\books.txt"));
        String line = booksReader.readLine();
        Random random = new Random();


        while (line != null) {
            String[] data = line.split("\\s+");


            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);

            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();


            Set<Category> bookCategories = new HashSet<>();

            for (int i = 0; i < random.nextInt(categories.size()); i++) {
                int categoryIndex = random.nextInt(categories.size());
                bookCategories.add(categories.get(categoryIndex));
            }

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setCategories(bookCategories);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);


            this.bookService.persist(book);

            line = booksReader.readLine();

        }


    }



}
