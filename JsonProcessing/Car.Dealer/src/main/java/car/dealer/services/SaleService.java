package car.dealer.services;


import car.dealer.dtoModels.ImportDtos.SaleImportDto;
import car.dealer.dtoModels.views.SalesWithDiscountDto;

import java.util.List;

public interface SaleService {

    void save(SaleImportDto saleImportDto);

    List<SalesWithDiscountDto> findSaleInfo();

}
