package product.shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.shop.dtoModels.bindingModels.Add.ProductAddDto;
import product.shop.dtoModels.bindingModels.ProductNamePriceDto;
import product.shop.dtoModels.viewModels.ProductInRangeDto;
import product.shop.dtoModels.viewModels.ProductNamePriceViewDto;
import product.shop.dtoModels.viewModels.ProductViewDto;
import product.shop.dtoModels.viewModels.SoldProductsCountAndInfo;
import product.shop.entities.Product;
import product.shop.entities.User;
import product.shop.io.ModelParser;
import product.shop.repositories.ProductRepository;
import product.shop.repositories.UserRepository;
import product.shop.servicies.ProductService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void save(ProductAddDto productAddDto) {
        Product product = ModelParser.getInstance().map(productAddDto, Product.class);

        this.productRepository.saveAndFlush(product);
    }

    @Override
    public List<ProductViewDto> findAll() {

        List <Product> products = this.productRepository.findAll();

        List<ProductViewDto> productViewDtos = new ArrayList<>();

        for (Product product: products) {
            ProductViewDto productViwDto = ModelParser.getInstance().map(product, ProductViewDto.class);
            productViewDtos.add(productViwDto);
        }

        return productViewDtos;
    }

    @Override
    public List<ProductInRangeDto> findByPriceIn() {

        BigDecimal minPrice = BigDecimal.valueOf(500);
        BigDecimal maxPrice = BigDecimal.valueOf(1000);

        List<Product> products = this.productRepository.getProductsByPriceBetweenAndBuyerIsNullOrderByPrice(minPrice, maxPrice);

        List<ProductInRangeDto> productInRangeDtos = new ArrayList<>();
        for (Product product:products) {
            ProductInRangeDto productInRangeDto = ModelParser.getInstance().map(product, ProductInRangeDto.class);
            productInRangeDtos.add(productInRangeDto);
        }

        return productInRangeDtos;
    }

    @Override
    public List<ProductNamePriceDto> findAllProductsNamePrice() {
        List<Product> allProducts = this.productRepository.findAll();

        List<ProductNamePriceDto> productNamePriceDtos = new ArrayList<>();
        for (Product product:allProducts) {
            ProductNamePriceDto productNamePriceDto = ModelParser.getInstance().map(product, ProductNamePriceDto.class);
            productNamePriceDtos.add(productNamePriceDto);
        }


        return productNamePriceDtos;
    }

    @Override
    public List<ProductNamePriceViewDto> findAllProductsNamePriceView() {
        List<Product> products = this.productRepository.findAll();

        List<ProductNamePriceViewDto> productNamePriceViewDtos = new ArrayList<>();
        for (Product product:products) {
            ProductNamePriceViewDto productNamePriceViewDto =
                    ModelParser.getInstance().map(product, ProductNamePriceViewDto.class);
            productNamePriceViewDtos.add(productNamePriceViewDto);
        }

        return productNamePriceViewDtos;
    }



}
