package game.store.commands;


import game.store.enums.Role;
import game.store.models.bindingModel.game.AddGame;
import game.store.models.bindingModel.user.LoggedInUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.DataValidator;
import game.store.utils.Session;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddGameCommand extends Command{
    public AddGameCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {
        LoggedInUser loggedInUser = Session.getCurrentLoggedInUser();

        if (loggedInUser == null) {
            return "Not logged in";
        }

        if (loggedInUser.getRole() != Role.ADMIN) {
            return "Only admins can add games";
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        AddGame addGame = null;
        try {
            addGame = new AddGame(params[0],
                    new BigDecimal(params[1]),
                    Double.parseDouble(params[2]),
                    params[3],
                    params[4],
                    params[5],
                    simpleDateFormat.parse(params[6]));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (! DataValidator.checkIsValid(addGame)) {
            return DataValidator.getInvalidParameterMessage(addGame);
        }

        super.getGameService().persist(addGame);
        return String.format("Added %s", params[0]);
    }
}
