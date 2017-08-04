package product.shop.servicies;



import product.shop.dtoModels.bindingModels.Add.ProductAddDto;
import product.shop.dtoModels.bindingModels.ProductNamePriceDto;
import product.shop.dtoModels.viewModels.ProductInRangeDto;
import product.shop.dtoModels.viewModels.ProductNamePriceViewDto;
import product.shop.dtoModels.viewModels.ProductViewDto;
import product.shop.dtoModels.viewModels.SoldProductsCountAndInfo;


import java.util.List;

public interface ProductService {

    void  save(ProductAddDto productDto);

    List<ProductViewDto> findAll();

    List<ProductInRangeDto> findByPriceIn();

    List <ProductNamePriceDto> findAllProductsNamePrice();

    List<ProductNamePriceViewDto> findAllProductsNamePriceView();


}
