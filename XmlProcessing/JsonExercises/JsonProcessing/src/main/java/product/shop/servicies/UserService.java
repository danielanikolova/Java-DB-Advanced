package product.shop.servicies;

import product.shop.dtoModels.bindingModels.Add.UserAddDto;
import product.shop.dtoModels.bindingModels.UserDto;
import product.shop.dtoModels.bindingModels.UserFirstLastNameDto;
import product.shop.dtoModels.bindingModels.xmlViewDto.SuccessfullySoldProducts.SellerWithProductsXmlList;
import product.shop.dtoModels.viewModels.SellerWithProductsDto;
import product.shop.dtoModels.viewModels.Problem4.UsersCountDto;



import java.util.List;

public interface UserService {
    void save(UserAddDto userDto);

    List<UserDto> findAll();

    List<UserFirstLastNameDto>findAllFirstLastName();


    List<SellerWithProductsDto>findAllUsersWithProducts();

    UsersCountDto findUsersCount();

    SellerWithProductsXmlList findSellerList();








}
