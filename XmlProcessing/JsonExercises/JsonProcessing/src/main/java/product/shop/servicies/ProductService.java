package product.shop.servicies;



import product.shop.dtoModels.bindingModels.Add.ProductAddDto;
import product.shop.dtoModels.bindingModels.ProductNamePriceDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.ProductsExportXmlDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.ProductsInRange.ProductsInRangeXml;
import product.shop.dtoModels.viewModels.Problem4.SoldProductsDto;
import product.shop.dtoModels.viewModels.ProductInRangeDto;
import product.shop.dtoModels.viewModels.Problem4.ProductNamePriceViewDto;
import product.shop.dtoModels.viewModels.ProductViewDto;


import java.util.List;
import java.util.Set;

public interface ProductService {

    void  save(ProductAddDto productDto);

    List<ProductViewDto> findAll();

    List<ProductInRangeDto> findByPriceIn();

    List <ProductNamePriceDto> findAllProductsNamePrice();

    List<ProductNamePriceViewDto> findAllProductsNamePriceView();

    Set<SoldProductsDto> findSoldProductsDto();

    //Xml

    ProductsExportXmlDto getProductsToExportXml();

    ProductsInRangeXml getAllProductsInRange();




}
