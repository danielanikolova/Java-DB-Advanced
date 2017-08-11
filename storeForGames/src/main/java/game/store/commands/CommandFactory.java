package game.store.commands;


import game.store.services.GameService;
import game.store.services.UserService;

import java.lang.reflect.InvocationTargetException;

public class CommandFactory {

    private static final String COMMAND_SUFFIX = "Command";

    private UserService userService;
    private GameService gameService;

    public CommandFactory(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }



    public Executable getCommand(String command)throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException{
        switch (command){
            case "Register":
                return new RegisterCommand(this.userService, this.gameService);

            case "Login":
                return new LoginCommand(this.userService, this.gameService);

            case "Logout":
                return new LogoutCommand(this.userService, this.gameService);
            case "AddGame":
                return new AddGameCommand(this.userService, this.gameService);
            case "AllGames":
                return new AllGamesCommand(this.userService, this.gameService);
            case "EditGame":
                return new EditGameCommand(this.userService, this.gameService);
            case "DeleteGame":
                return new DeleteGameCommand(this.userService, this.gameService);

            case "GameDetails":
                return new GameDetailsCommand(this.userService, this.gameService);
            case "AddToShoppingCart":
                return new AddToShoppingCart(this.userService, this.gameService);
            case "RemoveFromShoppingCart":
                return new RemoveFromShoppingCart(this.userService, this.gameService);
            case "BuyGames":
                return new BuyGames(this.userService, this.gameService);
            case "OwnedGames":
                return new OwnedGames(this.userService, this.gameService);
        }
        return null;
    }
}
