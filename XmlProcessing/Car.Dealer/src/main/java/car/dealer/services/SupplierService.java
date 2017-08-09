package car.dealer.services;


import car.dealer.dtoModels.jsonImportDtos.SupplierImportDto;
import car.dealer.dtoModels.views.LocalSupplierViewDto;
import car.dealer.dtoModels.xmlImportDtos.SupplierImportXml;
import car.dealer.dtoModels.xmlViewModels.LocalSupplierListXml;
import car.dealer.dtoModels.xmlViewModels.LocalSupplierViewXml;
import car.dealer.entities.Supplier;

import java.util.List;

public interface SupplierService {

    void save(SupplierImportDto supplierImportDto);

    List<Supplier>findAll();

    List<LocalSupplierViewDto>findAllLocalSupplier();

    List<LocalSupplierViewXml>findAllLocalSupplierXml();

    LocalSupplierListXml getListFromSuppliersXml();


}
