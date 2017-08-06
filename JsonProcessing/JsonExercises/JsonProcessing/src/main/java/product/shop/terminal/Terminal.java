package product.shop.terminal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import product.shop.dtoModels.bindingModels.Add.CategoryAddDto;
import product.shop.dtoModels.bindingModels.Add.ProductAddDto;
import product.shop.dtoModels.bindingModels.Add.UserAddDto;
import product.shop.dtoModels.bindingModels.CategoryDto;
import product.shop.dtoModels.bindingModels.UserDto;
import product.shop.dtoModels.viewModels.*;
import product.shop.io.JsonParser;
import product.shop.servicies.CategoryService;
import product.shop.servicies.ProductService;
import product.shop.servicies.UserService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class Terminal implements CommandLineRunner {
   private final CategoryService categoryService;
   private final UserService userService;
   private final ProductService productService;
   private final JsonParser jsonParser;

   @Autowired
    public Terminal(CategoryService categoryService, UserService userService, ProductService productService, JsonParser jsonParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
       this.jsonParser = jsonParser;
   }

    @Override
    public void run(String... strings) throws Exception {
//       importUsers();
//       importCategories();
//        importProducts();
//
//        export();

        exportProductsInRange();

 //       exportSellersWithProducts();
  //      exportCategoriesByProductsCount();

 //       exportUserWithAtLeastOneSoldProductCount();


    }

    private  void exportUserWithAtLeastOneSoldProductCount(){


    }

    private void exportCategoriesByProductsCount(){

       List<CategoryByProductsCountDto> categories = this.categoryService.CategoriesByProductsCount();

       this.jsonParser.writeObject(categories, "/src/main/resources/files.out/categoriesByCount.json");
    }

    private  void  exportSellersWithProducts(){

       List<SellerWithProductsDto> sellerWithProductsDtos = this.userService.findAllUsersWithProducts();

       this.jsonParser.writeObject(sellerWithProductsDtos, "/src/main/resources/files.out/sellersWithProducts.json");

    }


    private void exportProductsInRange(){
       List<ProductInRangeDto> productInRangeDtoList = this.productService.findByPriceIn();

       this.jsonParser.writeObject(productInRangeDtoList, "/src/main/resources/files.out/productsInRange.json");

    }


    public void export(){
       List<ProductViewDto>productViewDtos = this.productService.findAll();

       this.jsonParser.writeObject(productViewDtos, "/src/main/resources/files.out/productsExport.json");

   }

    public void importUsers(){

        UserAddDto[] users = this.jsonParser.getObject(UserAddDto[].class, "/files.in/users.json");

        for (UserAddDto user:users) {
            this.userService.save(user);
        }

   }

   public void importCategories(){

       CategoryAddDto[] categories = this.jsonParser.getObject(CategoryAddDto[].class, "/files.in/categories.json");

       for (CategoryAddDto category: categories) {
           this.categoryService.save(category);
       }
   }

   @Transactional
   public void importProducts(){
       Random random = new Random();

       int count = 0;
       List<UserDto> users = this.userService.findAll();
       List<CategoryDto> categories = this.categoryService.findAll();

       ProductAddDto[] productAddDtos =
               this.jsonParser.getObject(ProductAddDto[].class, "/files.in/products.json");
       for (ProductAddDto productAddDto: productAddDtos) {
           Set<CategoryDto>categoryDtoSet = new HashSet<>();
           UserDto seller = users.get(random.nextInt(users.size()));
           UserDto buyer = users.get(random.nextInt(users.size()));

           if (buyer.getId().equals(seller.getId())|| count%10 == 0){
               buyer = null;
           }


           for (int i = -1; i < random.nextInt(10); i++) {
              categoryDtoSet.add(categories.get(random.nextInt(categories.size())));
           }
           productAddDto.setBuyer(buyer);
           productAddDto.setSeller(seller);
           productAddDto.setCategories(categoryDtoSet);

           this.productService.save(productAddDto);

           count++;
       }
   }
}
