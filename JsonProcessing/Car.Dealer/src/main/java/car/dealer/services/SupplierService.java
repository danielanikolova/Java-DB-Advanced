package car.dealer.services;


import car.dealer.dtoModels.ImportDtos.SupplierImportDto;
import car.dealer.dtoModels.views.LocalSupplierViewDto;
import car.dealer.entities.Supplier;

import java.util.List;

public interface SupplierService {

    void save(SupplierImportDto supplierImportDto);

    List<Supplier>findAll();

    List<LocalSupplierViewDto>findAllLocalSupplier();

}
