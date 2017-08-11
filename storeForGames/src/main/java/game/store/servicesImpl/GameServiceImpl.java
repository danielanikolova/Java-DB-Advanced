package game.store.servicesImpl;

import game.store.entities.Game;
import game.store.models.bindingModel.ViewModels.game.GameDetail;
import game.store.models.bindingModel.ViewModels.game.GameView;
import game.store.models.bindingModel.game.AddGame;
import game.store.models.bindingModel.game.DeleteGame;
import game.store.models.bindingModel.game.EditGame;

import game.store.models.bindingModel.game.ShoppingCartGame;
import game.store.repositories.GameRepository;
import game.store.services.GameService;
import game.store.utils.ModelParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class GameServiceImpl implements GameService{


    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void persist(AddGame addGame) {
        Game game = ModelParser.getInstance().map(addGame, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public List<GameView> getAll() {
        List<Game> games = this.gameRepository.findAll();
        List<GameView> gameViews = new ArrayList<>();

        for (Game game : games) {
            GameView gameView = ModelParser.getInstance().map(game, GameView.class);
            gameViews.add(gameView);
        }

        return gameViews;
    }

    @Override
    public void deleteGame(Long id) {

        Game game = this.gameRepository.findOne(id);

        if (game==null){
            return;
        }

        this.gameRepository.delete(id);

    }

    @Override
    public DeleteGame findById(Long id) {

        Game game = this.gameRepository.findOne(id);

        DeleteGame deleteGame = ModelParser.getInstance().map(game, DeleteGame.class);

        if (deleteGame==null){
            return deleteGame = null;
        }

        return deleteGame;
    }

    @Override
    public EditGame editGame(Long id) {
        Game game = this.gameRepository.findOne(id);

        EditGame editGame =null;

        if (game == null){
            return editGame = null;
        }
        editGame = ModelParser.getInstance().map(game, EditGame.class);

        return editGame;

    }

    @Override
    public void persistEditions(EditGame editGame) {
        Long id = editGame.getId();
        BigDecimal price = editGame.getPrice();
        Double size = editGame.getSize();

        Game game = this.gameRepository.findOne(id);

        if (game==null){
            return;
        }

       game.setPrice(price);
        game.setSize(size);

        this.gameRepository.saveAndFlush(game);

    }

    @Override
    public GameDetail findGameDetailsView(String title) {
       Game game = this.gameRepository.findByTitle(title);
       if (game==null){
           return null;
       }

       return ModelParser.getInstance().map(game, GameDetail.class);
    }

    @Override
    public ShoppingCartGame findByTitle(String title) {
        Game game = this.gameRepository.findByTitle(title);
        if(game == null){
            return null;
        }

        ShoppingCartGame shoppingCartGame = ModelParser.getInstance().map(game, ShoppingCartGame.class);

        return shoppingCartGame;
    }




}
