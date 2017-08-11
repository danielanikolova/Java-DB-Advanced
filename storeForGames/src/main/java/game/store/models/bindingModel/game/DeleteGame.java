package game.store.models.bindingModel.game;


public class DeleteGame {

    private Long id;
    private String title;

    public DeleteGame() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
