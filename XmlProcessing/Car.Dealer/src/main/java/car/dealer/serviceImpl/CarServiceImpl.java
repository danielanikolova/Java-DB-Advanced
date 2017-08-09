package car.dealer.serviceImpl;

import car.dealer.dtoModels.jsonImportDtos.CarImportDto;
import car.dealer.dtoModels.views.CarAndPartsView;
import car.dealer.dtoModels.views.CarInfoView;
import car.dealer.dtoModels.views.CarsFromToyotaViewDto;
import car.dealer.dtoModels.views.PartInfoView;
import car.dealer.dtoModels.xmlViewModels.CarsFromToyotaXml;
import car.dealer.dtoModels.xmlViewModels.Query4.CarInfoXml;
import car.dealer.entities.Car;
import car.dealer.entities.Part;
import car.dealer.io.ModelParser;
import car.dealer.repositories.CarRepository;
import car.dealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void save(CarImportDto carImportDto) {
        Car car = ModelParser.getInstance().map(carImportDto, Car.class);

        this.carRepository.saveAndFlush(car);
    }

    @Override
    public List<Car> findAll() {

        List<Car> cars = this.carRepository.findAll();

        return cars;
    }

    @Override
    public List<CarsFromToyotaViewDto> findAllToyotaCars() {

        List<Car> cars = this.carRepository.findFyMakeToyota();


        List<CarsFromToyotaViewDto> result = new ArrayList<>();

        for (Car car : cars) {
            CarsFromToyotaViewDto carsFromToyotaViewDto = ModelParser.getInstance()
                    .map(car, CarsFromToyotaViewDto.class);

            result.add(carsFromToyotaViewDto);
        }


        return result;
    }

    @Override
    public List<CarInfoView> findCarInfoAndTheirParts() {

        List<Car> cars = this.carRepository.findAll();

        List<CarInfoView> carInfoViewList = new ArrayList<>();

        for (Car car : cars) {

            CarInfoView carInfoView = ModelParser.getInstance().map(car, CarInfoView.class);
            carInfoViewList.add(carInfoView);

        }
        return carInfoViewList;
    }

    @Override
    public List<CarAndPartsView> findAllCarsAndParts() {

        List<Car> cars = this.carRepository.findAll();
        List<CarAndPartsView> carAndPartsViewList = new ArrayList<>();

        for (Car car : cars) {
            CarAndPartsView current = ModelParser.getInstance().map(car, CarAndPartsView.class);
            Set<Part> currentCarParts = car.getParts();
            Set<PartInfoView> partInfoViewSet = new HashSet<>();

            for (Part part : currentCarParts) {
                PartInfoView partInfoView = ModelParser.getInstance().map(part, PartInfoView.class);
                partInfoViewSet.add(partInfoView);
            }

            current.setParts(partInfoViewSet);

            carAndPartsViewList.add(current);
        }


        return carAndPartsViewList;
    }

    @Override
    public CarInfoView findCarById(Long id) {
        Car car = this.carRepository.findOne(id);

        CarInfoView current = ModelParser.getInstance().map(car, CarInfoView.class);


        return current;
    }

    @Override
    public CarsFromToyotaXml findListFromCarsToyotaXml() {

        List<CarsFromToyotaViewDto> cars = this.findAllToyotaCars();

        CarsFromToyotaXml currentList = new CarsFromToyotaXml();

        currentList.setCars(cars);


        return currentList;
    }

    @Override
    public List<CarInfoXml> getCarInfoXml() {

        List<Car> cars = this.carRepository.findAll();

        List<CarInfoXml> carInfoXmlList = new ArrayList<>();

        for (Car car: cars) {

            CarInfoXml currentCarInfo = ModelParser.getInstance().map(car, CarInfoXml.class);

           Set<Part> currentCarParts = car.getParts();
           Set<PartInfoView> partsInfoViewSet = new HashSet<>();

            for (Part part: currentCarParts) {

                PartInfoView partInfoView = ModelParser.getInstance()
                        .map(part, PartInfoView.class);

                partsInfoViewSet.add(partInfoView);

            }
            currentCarInfo.setParts(partsInfoViewSet);

            carInfoXmlList.add(currentCarInfo);

        }

        return carInfoXmlList;
    }


}
