package game.store.commands;



import game.store.models.bindingModel.game.ShoppingCartGame;
import game.store.models.bindingModel.user.LoggedInUser;

import game.store.models.bindingModel.user.ShoppingUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;


public class AddToShoppingCart extends Command{
    protected AddToShoppingCart(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in user";
        }

        String gameTitle = params[0];

        Long id = loggedInUser.getId();

        ShoppingCartGame shoppingCartGame = super.getGameService().findByTitle(gameTitle);

        ShoppingUser shoppingUser = super.getUserService().findById(id);

        if (shoppingUser.getBoughtGames().contains(shoppingCartGame)) {
            return "This game is already on the Bought games cart!";
        }

        if (shoppingUser.getShoppingCartGames().contains(shoppingCartGame)) {
            return "This game is already in the wish list cart!";
        }

        shoppingUser.getShoppingCartGames().add(shoppingCartGame);

        super.getUserService().saveShoppingCartGamesToUser(shoppingUser);


        return String.format("%s added to cart", shoppingCartGame.getTitle());


    }
}
