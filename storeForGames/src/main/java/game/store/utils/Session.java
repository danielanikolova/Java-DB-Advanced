package game.store.utils;

import game.store.models.bindingModel.user.LoggedInUser;

public class Session {

    private static LoggedInUser currentLoggedInUser;

    public static LoggedInUser getCurrentLoggedInUser() {
        return currentLoggedInUser;
    }

    public static void setCurrentLoggedInUser(LoggedInUser loggedInUser) {
        Session.currentLoggedInUser = loggedInUser;
    }

}
