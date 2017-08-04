package product.shop.dtoModels.viewModels;


import com.google.gson.annotations.Expose;
import product.shop.dtoModels.bindingModels.UserFirstLastNameDto;


import java.math.BigDecimal;

public class ProductInRangeDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private UserFirstLastNameDto seller;

    public ProductInRangeDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public UserFirstLastNameDto getSeller() {
        return seller;
    }

    public void setSeller(UserFirstLastNameDto seller) {
        this.seller = seller;
    }
}
