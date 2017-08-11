package game.store.services;


import game.store.models.bindingModel.game.ShoppingCartGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.models.bindingModel.user.RegisterUser;
import game.store.models.bindingModel.user.ShoppingUser;


public interface UserService {

    void persist(RegisterUser user);
    LoggedInUser findByEmailAndPassword(String email, String password);
    ShoppingUser findById(Long id);
    void  saveShoppingCartGamesToUser(ShoppingUser shoppingUser);

    void  removeShoppingCardGame(ShoppingUser shoppingUser);














}
