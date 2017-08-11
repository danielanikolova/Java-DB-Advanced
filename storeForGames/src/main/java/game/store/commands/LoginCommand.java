package game.store.commands;


import game.store.models.bindingModel.user.LoggedInUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

public class LoginCommand extends Command{
    public LoginCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        String username = params[0];
        String password = params[1];

        if (Session.getCurrentLoggedInUser() != null) {
            return "User already logged in";
        }

        LoggedInUser loggedInUser = super.getUserService().findByEmailAndPassword(username, password);
        if (loggedInUser == null) {
            return "Incorrect email / password";
        }

        Session.setCurrentLoggedInUser(loggedInUser);
        return String.format("Successfully logged in %s", loggedInUser.getFullName());
    }
}
