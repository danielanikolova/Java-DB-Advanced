package product.shop.dtoModels.viewModels;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class ProductNamePriceViewDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductNamePriceViewDto() {
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;

    }
}
