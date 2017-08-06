package car.dealer.dtoModels.ImportDtos;


import car.dealer.entities.Car;
import car.dealer.entities.Customer;

public class SaleImportDto {

    private Car car;
    private Customer customer;
    private Double discount;

    public SaleImportDto() {
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
