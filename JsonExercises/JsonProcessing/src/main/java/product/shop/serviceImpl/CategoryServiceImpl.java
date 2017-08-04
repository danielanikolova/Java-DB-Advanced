package product.shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.shop.dtoModels.bindingModels.Add.CategoryAddDto;
import product.shop.dtoModels.bindingModels.CategoryDto;
import product.shop.dtoModels.viewModels.CategoryByProductsCountDto;
import product.shop.entities.Category;
import product.shop.io.ModelParser;
import product.shop.repositories.CategoryRepository;
import product.shop.servicies.CategoryService;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void save(CategoryAddDto categoryAddDto) {
        Category category = ModelParser.getInstance().map(categoryAddDto, Category.class);

        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public List<CategoryDto> findAll() {

       List<Category> categories = this.categoryRepository.findAll();

       List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category: categories) {
            CategoryDto categoryDto = ModelParser.getInstance().map(category, CategoryDto.class);
            categoryDtos.add(categoryDto);

        }

        return categoryDtos;
    }

    @Override
    public List<CategoryByProductsCountDto> CategoriesByProductsCount() {

        List<Object[]> categories = this.categoryRepository.CategoriesByProductsCount();

        List<CategoryByProductsCountDto> categoryByProductsCountDtos = new ArrayList<>();

        for (Object[] category: categories) {
            CategoryByProductsCountDto categoryByProductsCountDto = new CategoryByProductsCountDto();
            categoryByProductsCountDto.setCategory((String) category[0]);
            categoryByProductsCountDto.setProductCount((BigInteger) category[1]);
            categoryByProductsCountDto.setAveragePrice((BigDecimal)category[2]);
            categoryByProductsCountDto.setTotalRevenue((BigDecimal) category[3]);
            categoryByProductsCountDtos.add(categoryByProductsCountDto);

        }

        return categoryByProductsCountDtos;
    }
}
