package product.shop.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.shop.dtoModels.bindingModels.Add.UserAddDto;
import product.shop.dtoModels.bindingModels.UserDto;
import product.shop.dtoModels.bindingModels.UserFirstLastNameDto;
import product.shop.dtoModels.viewModels.SellerWithProductsDto;
import product.shop.dtoModels.viewModels.UserWithSoldProductsDto;
import product.shop.dtoModels.viewModels.UsersAndProductsDto;
import product.shop.entities.Product;
import product.shop.entities.User;
import product.shop.io.ModelParser;
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

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
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
    public List<UserWithSoldProductsDto> findAllUserWithSoldProducts() {
        List<User> users = this.userRepository.findAllBySoldProducts();

        List<UserWithSoldProductsDto> userWithSoldProductsDtos = new ArrayList<>();

        for (User user: users) {
            UserWithSoldProductsDto UserWithSoldProductsDto = ModelParser.getInstance().map(user, UserWithSoldProductsDto.class);
            userWithSoldProductsDtos.add(UserWithSoldProductsDto);
        }

        return userWithSoldProductsDtos;
    }

    @Override
    public UsersAndProductsDto findUserCountAndProductInfo() {
        List <User> users = this.userRepository.findUsersWithProductsCount();

        List<UserWithSoldProductsDto> usersWithProductsList= new ArrayList<>();

        for (User user: users) {
            UserWithSoldProductsDto userWithProduct = ModelParser.getInstance().map(user, UserWithSoldProductsDto.class);
            usersWithProductsList.add(userWithProduct);
        }

        UsersAndProductsDto usersAndProductsDto = new UsersAndProductsDto();

        usersAndProductsDto.setUsersCount(users.size());
        usersAndProductsDto.setUsers(usersWithProductsList);


        return usersAndProductsDto;
    }
}
