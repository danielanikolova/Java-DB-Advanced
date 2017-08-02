package bookshop_system.repositories;

import bookshop_system.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

    @Query("select c from Category as c inner join c.books as b group by c having count(b) > 35 order by count(b) desc ")
    List<Category> findAllCategoriesOrderByBookCount();

}
