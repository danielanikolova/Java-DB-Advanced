package product.shop.dtoModels.viewModels;


import com.google.gson.annotations.Expose;
import product.shop.dtoModels.bindingModels.ProductNamePriceDto;

import java.util.Set;

public class SellerWithProductsDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductNamePriceDto> soldProducts;

    public SellerWithProductsDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductNamePriceDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductNamePriceDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
