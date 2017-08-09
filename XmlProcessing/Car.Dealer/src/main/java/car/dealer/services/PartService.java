package car.dealer.services;

import car.dealer.dtoModels.jsonImportDtos.PartImportDto;
import car.dealer.dtoModels.views.PartInfoView;
import car.dealer.dtoModels.xmlViewModels.Query4.PartsListXml;
import car.dealer.entities.Part;

import java.util.List;

public interface PartService {
    void save(PartImportDto partImportDto);

    List<Part> findAll();

    PartInfoView getPartNameAndPrice(Long id);



}
