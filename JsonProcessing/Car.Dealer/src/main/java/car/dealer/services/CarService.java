package car.dealer.services;


import car.dealer.dtoModels.ImportDtos.CarImportDto;
import car.dealer.dtoModels.views.CarAndPartsView;
import car.dealer.dtoModels.views.CarInfoView;
import car.dealer.dtoModels.views.CarsFromToyotaViewDto;
import car.dealer.entities.Car;

import java.util.List;

public interface CarService {

    void save(CarImportDto carImportDto);

    List<Car> findAll();

    List<CarsFromToyotaViewDto> findAllToyotaCars();

    List<CarInfoView> findCarInfoAndTheirParts();

    List<CarAndPartsView> findAllCarsAndParts();

    CarInfoView findCarById(Long id);
}
