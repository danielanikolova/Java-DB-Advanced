package product.shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.shop.dtoModels.bindingModels.Add.UserAddDto;
import product.shop.dtoModels.bindingModels.UserDto;
import product.shop.dtoModels.bindingModels.UserFirstLastNameDto;
import product.shop.dtoModels.viewModels.Problem4.UsersWithSoldProducts;
import product.shop.dtoModels.viewModels.SellerWithProductsDto;
import product.shop.dtoModels.viewModels.Problem4.UsersCountDto;
import product.shop.entities.Product;
import product.shop.entities.User;
import product.shop.io.ModelParser;
import product.shop.repositories.ProductRepository;
import product.shop.repositories.UserRepository;
import product.shop.servicies.UserService;

import javax.transaction.Transactional;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void save(UserAddDto userAddDto) {
        User user = ModelParser.getInstance().map(userAddDto, User.class);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public List<UserDto> findAll() {
       List <User> users = this.userRepository.findAll();

       List<UserDto> userDtos = new ArrayList<>();

        for (User user: users) {
            UserDto userDto = ModelParser.getInstance().map(user, UserDto.class);
            userDtos.add(userDto);
        }

        return userDtos;
    }

    @Override
    public List<UserFirstLastNameDto> findAllFirstLastName() {
        List <User> users = this.userRepository.findAll();

        List<UserFirstLastNameDto> userFirstLastNameDtos = new ArrayList<>();

        for (User user: users) {
            UserFirstLastNameDto userFirstLastNameDto = ModelParser.getInstance().map(user, UserFirstLastNameDto.class);
            userFirstLastNameDtos.add(userFirstLastNameDto);
        }

        return userFirstLastNameDtos;
    }



    @Override
    public List<SellerWithProductsDto> findAllUsersWithProducts() {

        List<User> users = this.userRepository.findAllBySoldProducts();

        for (User user:users) {
            Set<Product> soldProducts = user.getSoldProducts();
           ArrayList <Product>toDelete = new ArrayList<Product>();
            for (Product product: soldProducts) {

                if (product.getBuyer()==null){
                    toDelete.add(product);
                }

            }

            soldProducts.removeAll(toDelete);
        }

        List<SellerWithProductsDto> sellerWithProductsDtos = new ArrayList<>();

        for (User user: users) {
            SellerWithProductsDto sellerWithProductsDto = ModelParser.getInstance().map(user, SellerWithProductsDto.class);
            sellerWithProductsDtos.add(sellerWithProductsDto);
        }


        return sellerWithProductsDtos;
    }

    @Override
    public UsersCountDto findUsersCount() {

        List<Object[]> userIdAndProductsCount = this.userRepository.FindWithAtLeastOneSoldProduct();
        List<UsersWithSoldProducts> userList = new ArrayList<>();

        for (Object[] obj:userIdAndProductsCount) {

            Long userId = Long.parseLong((String) obj[0]);
            User user = this.userRepository.findOne(userId);
            UsersWithSoldProducts userInfoAndSoldProductsDto = ModelParser.getInstance()
                    .map(user, UsersWithSoldProducts.class);

            userList.add(userInfoAndSoldProductsDto);

        }

        UsersCountDto usersCountDto = new UsersCountDto();

        usersCountDto.setUsers(userList);


        return usersCountDto;
    }


}
