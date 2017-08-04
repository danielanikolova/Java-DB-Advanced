package product.shop.dtoModels.bindingModels;


import com.google.gson.annotations.Expose;

public class UserFirstLastNameDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;

    public UserFirstLastNameDto() {
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
}
