package product.shop.dtoModels.viewModels;

import com.google.gson.annotations.Expose;


import java.util.List;

public class UsersAndProductsDto {

    @Expose
    private Integer usersCount;
    @Expose
    private List<UserWithSoldProductsDto> users;

    public UsersAndProductsDto() {
    }

    public Integer getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(Integer usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserWithSoldProductsDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserWithSoldProductsDto> users) {
        this.users = users;
    }
}
