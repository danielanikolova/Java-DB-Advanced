package game.store.models.bindingModel.user;


import game.store.models.bindingModel.game.ShoppingCartGame;

import java.util.Set;

public class ShoppingUser {

    private Long id;
    private Set<ShoppingCartGame> shoppingCartGames;
    private Set<ShoppingCartGame> boughtGames;

    public ShoppingUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<ShoppingCartGame> getShoppingCartGames() {
        return shoppingCartGames;
    }

    public void setShoppingCartGames(Set<ShoppingCartGame> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    public Set<ShoppingCartGame> getBoughtGames() {
        return boughtGames;
    }

    public void setBoughtGames(Set<ShoppingCartGame> boughtGames) {
        this.boughtGames = boughtGames;
    }
}
