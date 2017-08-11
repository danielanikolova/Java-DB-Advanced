package game.store.models.bindingModel.ViewModels.game;


import java.math.BigDecimal;

public class GameView {

    private String title;
    private BigDecimal price;

    public GameView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getTitle(), this.getPrice());
    }
}
