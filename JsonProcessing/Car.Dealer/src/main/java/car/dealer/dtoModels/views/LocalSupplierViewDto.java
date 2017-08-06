package car.dealer.dtoModels.views;


import car.dealer.entities.Part;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class LocalSupplierViewDto {

    @Expose
    private Long Id;
    @Expose
    private String Name;

    private Set<Part> parts;

    @Expose
    @SerializedName("partsCount")
    private int partsCount;

    public LocalSupplierViewDto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
        this.setPartsCount(parts.size());
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
