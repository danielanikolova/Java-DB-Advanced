package game.store.commands;

import game.store.enums.Role;
import game.store.models.bindingModel.game.DeleteGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

public class DeleteGameCommand extends Command{
    protected DeleteGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

        if (loggedInUser == null){
            return  "Not logged in";
        }

        if (loggedInUser.getRole() != Role.ADMIN){

            return "Only admins can delete games";
        }

        Long id = Long.parseLong(params[0]);

        DeleteGame deleteGame = this.getGameService().findById(id);

        if (deleteGame == null){
            return "Invalid game id";
        }

       super.getGameService().deleteGame(id);


        return String.format("Deleted %s", deleteGame.getTitle());

    }
}
