package game.store.terminal;

import game.store.commands.CommandFactory;
import game.store.commands.Executable;
import game.store.services.GameService;
import game.store.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

@Component
public class Terminal implements CommandLineRunner{

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public Terminal(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }


    @Override
    public void run(String... strings) throws Exception {

        CommandFactory commandFactory = new CommandFactory(this.userService, this.gameService);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }

            String[] params = line.split("\\|");
            String command = params[0];
            String[] newParams = new String[params.length - 1];
            if (params.length > 1) {
                newParams = Arrays.copyOfRange(params, 1, params.length);
            }

            Executable executable = commandFactory.getCommand(command);
            String result = executable.execute(newParams);
            System.out.println(result);
        }


        return;
    }
}
