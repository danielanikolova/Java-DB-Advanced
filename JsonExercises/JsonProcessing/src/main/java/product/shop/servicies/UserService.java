package product.shop.servicies;

import product.shop.dtoModels.bindingModels.Add.UserAddDto;
import product.shop.dtoModels.bindingModels.UserDto;
import product.shop.dtoModels.bindingModels.UserFirstLastNameDto;
import product.shop.dtoModels.viewModels.SellerWithProductsDto;
import product.shop.dtoModels.viewModels.UserWithSoldProductsDto;
import product.shop.dtoModels.viewModels.UsersAndProductsDto;

import java.util.List;

public interface UserService {
    void save(UserAddDto userDto);

    List<UserDto> findAll();

    List<UserFirstLastNameDto>findAllFirstLastName();

    List<SellerWithProductsDto>findAllUsersWithProducts();

    List<UserWithSoldProductsDto>findAllUserWithSoldProducts();

    UsersAndProductsDto findUserCountAndProductInfo();





}
