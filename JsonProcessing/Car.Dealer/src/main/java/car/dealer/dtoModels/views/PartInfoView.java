package car.dealer.dtoModels.views;


import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class PartInfoView {

    @Expose
    private String Name;
    @Expose
    private BigDecimal Price;

    public PartInfoView() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }
}
