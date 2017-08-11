package game.store.commands;


import game.store.models.bindingModel.user.LoggedInUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.Session;

public class LogoutCommand extends Command{
    public LogoutCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        if (Session.getCurrentLoggedInUser() == null) {
            return "Cannot log out. No user was logged in.";
        }

        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();
        Session.setCurrentLoggedInUser(null);

        return String.format("User %s successfully logged out", loggedInUser.getFullName());
    }
}
