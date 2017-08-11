package game.store.commands;

import game.store.models.bindingModel.game.ShoppingCartGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.models.bindingModel.user.ShoppingUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;


public class RemoveFromShoppingCart extends Command{
    protected RemoveFromShoppingCart(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

        if (loggedInUser==null){
            return "Not logged in user!";
        }

        Long userId = loggedInUser.getId();
        String gameTitle = params[0];

        ShoppingCartGame shoppingCartGame = super.getGameService().findByTitle(gameTitle);

        ShoppingUser shoppingUser = super.getUserService().findById(userId);

        if (shoppingUser.getShoppingCartGames().contains(shoppingCartGame)){
            shoppingUser.getShoppingCartGames().remove(shoppingCartGame);
        }

       shoppingUser.getShoppingCartGames().remove(shoppingCartGame);
        super.getUserService().removeShoppingCardGame(shoppingUser);

        return String.format("%s was successfully removed from the Shopping cart!", shoppingCartGame.getTitle());
    }
}
