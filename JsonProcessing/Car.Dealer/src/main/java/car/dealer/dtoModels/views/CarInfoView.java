package car.dealer.dtoModels.views;

import car.dealer.entities.Part;
import com.google.gson.annotations.Expose;

import java.util.Set;

public class CarInfoView {
    @Expose
    private String Make;
    @Expose
    private String Model;
    @Expose
    private Long TravelledDistance;

    private Set<Part> Parts;

    public CarInfoView() {
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Long getTravelledDistance() {
        return TravelledDistance;
    }

    public void setTravelledDistance(Long travelledDistance) {
        TravelledDistance = travelledDistance;
    }

    public Set<Part> getParts() {
        return Parts;
    }

    public void setParts(Set<Part> parts) {
        Parts = parts;
    }
}
