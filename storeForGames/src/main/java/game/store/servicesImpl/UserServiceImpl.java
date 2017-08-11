package game.store.servicesImpl;


import game.store.entities.User;
import game.store.enums.Role;

import game.store.models.bindingModel.user.LoggedInUser;
import game.store.models.bindingModel.user.RegisterUser;

import game.store.models.bindingModel.user.ShoppingUser;
import game.store.repositories.GameRepository;
import game.store.repositories.UserRepository;
import game.store.services.UserService;
import game.store.utils.ModelParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void persist(RegisterUser registerUser) {

        User user = ModelParser.getInstance().map(registerUser, User.class);

        if (this.userRepository.findAll().size() > 0) {
            user.setRole(Role.USER);
        } else {
            user.setRole(Role.ADMIN);
        }

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public LoggedInUser findByEmailAndPassword(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password);
        LoggedInUser loggedInUser = null;

        if (user != null) {
            loggedInUser = ModelParser.getInstance().map(user, LoggedInUser.class);
        }

        return loggedInUser;
    }


    @Override
    public ShoppingUser findById(Long id) {
        User user = this.userRepository.findOne(id);

        return ModelParser.getInstance().map(user, ShoppingUser.class);
    }

    @Override
    public void saveShoppingCartGamesToUser(ShoppingUser shoppingUser) {
        User user = this.userRepository.getOne(shoppingUser.getId());

        ModelParser.getInstance().map(shoppingUser,user);
        this.userRepository.saveAndFlush(user);

    }

    @Override
    public void removeShoppingCardGame(ShoppingUser shoppingUser) {
        User user = this.userRepository.findOne(shoppingUser.getId());

       ModelParser.getInstance().map(shoppingUser, user);
       this.userRepository.saveAndFlush(user);

    }
}