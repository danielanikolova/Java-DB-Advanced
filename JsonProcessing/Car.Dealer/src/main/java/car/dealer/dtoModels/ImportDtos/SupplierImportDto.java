package car.dealer.dtoModels.ImportDtos;

import com.google.gson.annotations.Expose;

public class SupplierImportDto {

    @Expose
    private String name;
    @Expose
    private boolean isImporter;

    public SupplierImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
