package user.system.servicesInterf;


import user.system.entities.User;

import java.util.Date;
import java.util.List;

public interface UserServiceInter {

    void persist(User user);

    void delete(User user);

    List<Object[]> getUsersByEmailProvider(String provider);

    List<User> getNotActiveUsers(Date date);



}
