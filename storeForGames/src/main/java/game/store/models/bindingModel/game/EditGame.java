package game.store.models.bindingModel.game;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;


import java.util.Date;

@Component
public class EditGame {

    private Long id;

    @DecimalMin(value = "0.00", message = "Price must be positive number")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2)
    private BigDecimal price;

    private Double size;

    public EditGame() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }


}
