package game.store.services;

import game.store.models.bindingModel.ViewModels.game.GameDetail;
import game.store.models.bindingModel.ViewModels.game.GameView;
import game.store.models.bindingModel.game.AddGame;
import game.store.models.bindingModel.game.DeleteGame;
import game.store.models.bindingModel.game.EditGame;
import game.store.models.bindingModel.game.ShoppingCartGame;


import java.util.List;

public interface GameService {

    void persist(AddGame addGame);
    List<GameView> getAll();
    void deleteGame(Long id);
    DeleteGame findById(Long id);
    EditGame editGame(Long id);
    void persistEditions(EditGame editGame);
    GameDetail findGameDetailsView(String title);
    ShoppingCartGame findByTitle(String title);








}
