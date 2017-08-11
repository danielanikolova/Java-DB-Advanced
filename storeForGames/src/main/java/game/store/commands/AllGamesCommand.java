package game.store.commands;


import game.store.models.bindingModel.ViewModels.game.GameView;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

import java.util.List;
import java.util.stream.Collectors;

public class AllGamesCommand extends Command{
    protected AllGamesCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

            LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

            if (loggedInUser == null) {
                return "Not logged in";
            }

            List<GameView> games = super.getGameService().getAll();

            return games.stream().map(Object::toString)
                    .collect(Collectors.joining("\n"));
    }
}
