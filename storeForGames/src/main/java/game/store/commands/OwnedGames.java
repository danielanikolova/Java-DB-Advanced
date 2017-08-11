package game.store.commands;


import game.store.models.bindingModel.game.ShoppingCartGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.models.bindingModel.user.ShoppingUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

public class OwnedGames extends Command{
    protected OwnedGames(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in user";
        }

        ShoppingUser shoppingUser = super.getUserService().findById(loggedInUser.getId());

        StringBuilder sb = new StringBuilder();

        for (ShoppingCartGame game: shoppingUser.getBoughtGames()) {
            sb.append(game.toString());
        }

        return String.format(sb.toString());
    }
}
