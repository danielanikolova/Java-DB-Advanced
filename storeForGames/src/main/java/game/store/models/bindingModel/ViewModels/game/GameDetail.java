package game.store.models.bindingModel.ViewModels.game;


import java.math.BigDecimal;
import java.util.Date;

public class GameDetail {
    private Long id;
    private String title;
    private String trailer;
    private String thumbnailURL;
    private Double size;
    private BigDecimal price;
    private String description;
    private Date releaseDate;

    public GameDetail() {
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

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n"+
                "Price: " + price + "\n"+
                "Size: " + size +"\n"+
                "Trailer: " + trailer +"\n"+
                "ThumbnailURL: " + thumbnailURL +"\n"+
                "Description: " + description +"\n"+
                "ReleaseDate=" + releaseDate;
    }
}
