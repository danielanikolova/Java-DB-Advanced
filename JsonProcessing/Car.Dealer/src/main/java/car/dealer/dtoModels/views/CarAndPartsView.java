package car.dealer.dtoModels.views;


import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarAndPartsView {

    @Expose
    private CarInfoView car;

    @Expose
    private Set<PartInfoView> parts;

    public CarAndPartsView() {
    }

    public CarInfoView getCar() {
        return car;
    }

    public void setCar(CarInfoView car) {
        this.car = car;
    }

    public Set<PartInfoView> getParts() {
        return parts;
    }

    public void setParts(Set<PartInfoView> parts) {
        this.parts = parts;
    }
}
