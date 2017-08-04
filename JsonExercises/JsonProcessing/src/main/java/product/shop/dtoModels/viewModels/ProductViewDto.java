package product.shop.dtoModels.viewModels;

import com.google.gson.annotations.Expose;
import product.shop.dtoModels.bindingModels.Add.UserAddDto;

import java.math.BigDecimal;


public class ProductViewDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;
    @Expose
    private UserAddDto buyer;


    public ProductViewDto() {
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

    public UserAddDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserAddDto buyer) {
        this.buyer = buyer;
    }


}
