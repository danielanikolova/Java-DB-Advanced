package product.shop.dtoModels.viewModels.Problem4;

import com.google.gson.annotations.Expose;

public class UsersWithSoldProducts {
    @Expose
    private String firstName;
    @Expose
    private String LastName;
    @Expose
    private int age;
    @Expose
    private SoldProductsDto soldProducts;


    public UsersWithSoldProducts() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public SoldProductsDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsDto soldProducts) {
        this.soldProducts = soldProducts;
    }


}
