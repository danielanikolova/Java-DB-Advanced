package product.shop.dtoModels.viewModels;


import com.google.gson.annotations.Expose;
import product.shop.entities.Product;

import java.util.Set;

public class UserWithSoldProductsDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private SoldProductsCountAndInfo soldProducts;
//    @Expose
//    private Set<ProductNamePriceViewDto> soldProducts;

    public UserWithSoldProductsDto() {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

//    public Set<ProductNamePriceViewDto> getSoldProducts() {
//        return soldProducts;
//    }
//
//    public void setSoldProducts(Set<ProductNamePriceViewDto> soldProducts) {
//        this.soldProducts = soldProducts;
//    }


    public SoldProductsCountAndInfo getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsCountAndInfo soldProducts) {
        this.soldProducts = soldProducts;
    }
}
