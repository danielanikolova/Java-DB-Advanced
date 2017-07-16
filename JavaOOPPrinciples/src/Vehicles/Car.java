package Vehicles;

public class Car extends VehicleImpl{
    public Car(Double quantity, Double consumption) {
        super(quantity, consumption +0.9);
    }
}
