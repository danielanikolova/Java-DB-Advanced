package product.shop.dtoModels.viewModels.Problem4;


import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersCountDto {

    @Expose
    @XmlAttribute(name = "count")
    private int count;
    @Expose
    @XmlElement(name = "user")
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
