package game.store.commands;

import game.store.entities.Game;
import game.store.models.bindingModel.ViewModels.game.GameDetail;
import game.store.services.GameService;
import game.store.services.UserService;

public class GameDetailsCommand extends Command{

    protected GameDetailsCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {


        GameDetail gameDetail = null;

        String title = params[0];

        return  super.getGameService().findGameDetailsView(title).toString();

    }
}
