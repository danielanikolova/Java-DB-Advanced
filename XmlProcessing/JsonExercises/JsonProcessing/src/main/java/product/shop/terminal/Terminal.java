package product.shop.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import product.shop.dtoModels.bindingModels.Add.CategoryAddDto;
import product.shop.dtoModels.bindingModels.Add.ProductAddDto;
import product.shop.dtoModels.bindingModels.Add.UserAddDto;
import product.shop.dtoModels.bindingModels.CategoryDto;
import product.shop.dtoModels.bindingModels.UserDto;
import product.shop.dtoModels.bindingModels.xmlDtos.CategoriesImportXml;
import product.shop.dtoModels.bindingModels.xmlDtos.ProductsImportXml;
import product.shop.dtoModels.bindingModels.xmlDtos.UsersImportXmlDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.CategoriesByProductsCount.CategoriesByProductCountXmlList;
import product.shop.dtoModels.bindingModels.xmlViewDto.ProductsExportXmlDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.ProductsInRange.ProductsInRangeXml;
import product.shop.dtoModels.bindingModels.xmlViewDto.SuccessfullySoldProducts.SellerWithProductsXmlList;
import product.shop.dtoModels.viewModels.*;
import product.shop.dtoModels.viewModels.Problem4.UsersCountDto;
import product.shop.io.JsonParser;
import product.shop.io.XmlParser;
import product.shop.servicies.CategoryService;
import product.shop.servicies.ProductService;
import product.shop.servicies.UserService;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {
   private final CategoryService categoryService;
   private final UserService userService;
   private final ProductService productService;
   private final JsonParser jsonParser;
   private final XmlParser xmlParser;

   @Autowired
    public Terminal(CategoryService categoryService, UserService userService, ProductService productService, JsonParser jsonParser, XmlParser xmlParser) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
       this.jsonParser = jsonParser;
       this.xmlParser = xmlParser;
   }

    @Override
    public void run(String... strings) throws Exception {

       //Json Commands

//       importUsers();
//       importCategories();
//        importProducts();//
//        export();
//        exportProductsInRange();
 //       exportSellersWithProducts();
  //      exportCategoriesByProductsCount();
 //       exportUserWithAtLeastOneSoldProductCount();

        //Xml Commands

 //       importUsersFromXml();
//        importCategoriesXml();
  //      importProductsXml();
//        exportToXml();
//        getProductsInRangeList();
//        writeSuccessfullySoldProducts();
//        writeCategoriesByProductsCount();
//        writeUsersAndProductsXml();

    }

    //XmlCommands

    public void writeUsersAndProductsXml(){
       UsersCountDto result = this.userService.findUsersCount();

        try {
            this.xmlParser.writeObject(result, "src/main/resources/xmlFiles.out/usersAndProducts.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void writeCategoriesByProductsCount(){
        CategoriesByProductCountXmlList result = this.categoryService.findAllCyProductsCount();

        try {
            this.xmlParser.writeObject(result, "src/main/resources/xmlFiles.out/categoriesByPrCount.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeSuccessfullySoldProducts(){

        SellerWithProductsXmlList result = this.userService.findSellerList();

        try {
            this.xmlParser.writeObject(result, "src/main/resources/xmlFiles.out/successfullySoldProducts.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getProductsInRangeList(){
        ProductsInRangeXml productsInRangeXml = this.productService.getAllProductsInRange();

        try {
            this.xmlParser.writeObject(productsInRangeXml, "src/main/resources/xmlFiles.out/exportProductsInRangeXml.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportToXml(){
        ProductsExportXmlDto productsExportXmlDto = this.productService.getProductsToExportXml();

        for (ProductViewDto productViewDtos:productsExportXmlDto.getProductViewDtos()) {
            productViewDtos.setDate(new Date());
        }

        try {
            this.xmlParser.writeObject(productsExportXmlDto, "src/main/resources/xmlFiles.out/exportProductsXml.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void importProductsXml(){

        Random random = new Random();

        int count = 0;
        List<UserDto> users = this.userService.findAll();
        List<CategoryDto> categories = this.categoryService.findAll();

        ProductsImportXml productAddDtos =
                null;
        try {
            productAddDtos = this.xmlParser.getObject(ProductsImportXml.class, "/xmlFiles.in/products.xml");

            for (ProductAddDto productAddDto: productAddDtos.getProductAddDtos()) {
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

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private  void importUsersFromXml(){

        UsersImportXmlDto users = null;
        try {
            users = this.xmlParser
                    .getObject(UsersImportXmlDto.class, "/xmlFiles.in/users.xml");

            for (UserAddDto user:users.getUserAddDtos()) {
                this.userService.save(user);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importCategoriesXml(){

        CategoriesImportXml categories = null;
        try {
            categories = this.xmlParser
                    .getObject(CategoriesImportXml.class, "/xmlFiles.in/categories.xml");

            for (CategoryAddDto category: categories.getCategoryAddDtos()) {
                this.categoryService.save(category);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //JsonCommands


    private  void exportUserWithAtLeastOneSoldProductCount(){

       UsersCountDto usersCountDtos = this.userService.findUsersCount();

       this.jsonParser.writeObject(usersCountDtos, "/src/main/resources/files.out/problem4.json");

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

    @Transactional
    public void importUsers(){

        UserAddDto[] users = this.jsonParser.getObject(UserAddDto[].class, "/files.in/users.json");

        for (UserAddDto user:users) {
            this.userService.save(user);
        }

   }


    @Transactional
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
