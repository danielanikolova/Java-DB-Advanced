package user.system.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.system.entities.User;
import user.system.repositories.UserRepository;
import user.system.servicesInterf.UserServiceInter;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInter{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(User user) {

        this.userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public List<Object[]> getUsersByEmailProvider(String provider) {
        return this.userRepository.getUsersByEmailProvider(provider);
    }

    @Override
    public List<User> getNotActiveUsers(Date date) {
        return this.userRepository.getNotActiveUsers(date);
    }


}
