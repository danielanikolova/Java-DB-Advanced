package car.dealer.terminal;


import car.dealer.dtoModels.SupplierImportDto;
import car.dealer.io.JsonParser;
import car.dealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner{

    private final JsonParser jsonParser;
    private final SupplierService supplierService;

    @Autowired
    public Terminal(JsonParser jsonParser, SupplierService supplierService) {
        this.jsonParser = jsonParser;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... strings) throws Exception {

        importSuppliers();


    }

    public void importSuppliers(){

        SupplierImportDto[] suppliers = this.jsonParser
                .getObject(SupplierImportDto[].class, "/files.in/suppliers.json");

        for (SupplierImportDto supplierImportDto: suppliers) {
            this.supplierService.save(supplierImportDto);
        }

    }

}
