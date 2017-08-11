package game.store.commands;

import game.store.models.bindingModel.user.RegisterUser;
import game.store.services.GameService;
import game.store.services.UserService;
import game.store.utils.DataValidator;

public class RegisterCommand extends Command{

    public RegisterCommand(UserService userService, GameService gameService) {
        super(userService, gameService);
    }

    @Override
    public String execute(String... params) {

        RegisterUser registerUser = new RegisterUser();
        registerUser.setEmail(params[0]);
        registerUser.setPassword(params[1]);
        registerUser.setConfirmPassword(params[2]);
        registerUser.setFullName(params[3]);

        if (!DataValidator.checkIsValid(registerUser)) {
            return DataValidator.getInvalidParameterMessage(registerUser);
        }

        try {
            super.getUserService().persist(registerUser);
        } catch (Exception e) {
            return e.getMessage();
        }


        return String.format("%s was registered", params[3]);
    }
}
