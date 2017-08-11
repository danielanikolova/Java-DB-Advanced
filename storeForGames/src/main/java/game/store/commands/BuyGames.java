package game.store.commands;


import game.store.models.bindingModel.game.ShoppingCartGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.models.bindingModel.user.ShoppingUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

import java.util.Set;

public class BuyGames extends Command{
    protected BuyGames(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in user";
        }

        ShoppingUser shoppingUser = super.getUserService().findById(loggedInUser.getId());

        Set<ShoppingCartGame> gamesToBy = shoppingUser.getShoppingCartGames();

        StringBuilder sb = new StringBuilder();
        for (ShoppingCartGame game:gamesToBy) {
            shoppingUser.getBoughtGames().add(game);
            sb.append(game.toString());
        }

        super.getUserService().saveShoppingCartGamesToUser(shoppingUser);

        return String.format("Successfully bought games:\n %s",sb.toString());
    }
}
