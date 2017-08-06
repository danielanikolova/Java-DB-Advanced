package product.shop.dtoModels.viewModels.Problem4;


import com.google.gson.annotations.Expose;

import java.util.List;

public class UsersCountDto {

    @Expose
    private int count;
    @Expose
    private List<UsersWithSoldProducts> users;

    public UsersCountDto() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UsersWithSoldProducts> getUsers() {
        return users;
    }

    public void setUsers(List<UsersWithSoldProducts> users) {
        this.users = users;
    }
}
