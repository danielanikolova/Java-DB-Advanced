package bookshop_system.ServiceImpl;

import bookshop_system.entities.Category;
import bookshop_system.repositories.CategoryRepository;
import bookshop_system.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void persist(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategoriesOrderByBookCount() {
        return this.categoryRepository.findAllCategoriesOrderByBookCount();
    }
}
