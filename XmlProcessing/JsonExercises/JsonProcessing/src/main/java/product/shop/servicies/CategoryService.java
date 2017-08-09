package product.shop.servicies;

import product.shop.dtoModels.bindingModels.Add.CategoryAddDto;
import product.shop.dtoModels.bindingModels.CategoryDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.CategoriesByProductsCount.CategoriesByProductCountXmlList;
import product.shop.dtoModels.viewModels.CategoryByProductsCountDto;


import java.util.List;

public interface CategoryService {

    void save(CategoryAddDto categoryDto);
    List<CategoryDto>findAll();

    List<CategoryByProductsCountDto>CategoriesByProductsCount();

    CategoriesByProductCountXmlList findAllCyProductsCount();
}
