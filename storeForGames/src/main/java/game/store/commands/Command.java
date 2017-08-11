package game.store.commands;


import game.store.services.GameService;
import game.store.services.UserService;

public abstract class Command implements Executable {

    private final UserService userService;
    private final GameService gameService;

    protected Command(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    public UserService getUserService() {
        return userService;
    }

    public GameService getGameService() {
        return gameService;
    }
}
