package bookshop_system.services;

import bookshop_system.entities.Category;

import java.util.List;

public interface CategoryService {
    void persist(Category category);


    List<Category> findAllCategoriesOrderByBookCount();
}
