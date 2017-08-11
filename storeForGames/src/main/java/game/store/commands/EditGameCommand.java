package game.store.commands;

import game.store.enums.Role;
import game.store.models.bindingModel.game.EditGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

import java.math.BigDecimal;

public class EditGameCommand extends Command{


    protected EditGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }


    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();
        if (loggedInUser == null){
            return "Not logged in user!";
        }

        if (loggedInUser.getRole() != Role.ADMIN){
            return "The logged in user is not ADMIN";
        }

        Long id = Long.parseLong(params[0]);

        EditGame editGame = this.getGameService().editGame(id);
        if (editGame == null) {
            return "Invalid game id";
        }

        String[] priceData = params[1].split("=");
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(priceData[1]));
        String[] sizeData = params[2].split("=");
        double size = Double.parseDouble(sizeData[1]);

        editGame.setId(id);
        editGame.setPrice(price);
        editGame.setSize(size);
        super.getGameService().persistEditions(editGame);



        return String.format("The game with id %s was updated", id);
    }
}
