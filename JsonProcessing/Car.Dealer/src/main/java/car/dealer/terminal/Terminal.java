package car.dealer.terminal;

import car.dealer.dtoModels.ImportDtos.*;
import car.dealer.dtoModels.views.*;
import car.dealer.entities.*;
import car.dealer.io.JsonParser;
import car.dealer.repositories.PartRepository;
import car.dealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Terminal implements CommandLineRunner{

    private final JsonParser jsonParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private  final SaleService saleService;

    @Autowired
    public Terminal(JsonParser jsonParser, SupplierService supplierService, PartRepository partRepository, PartService partService, CarService carService, CustomerService customerService, SaleService saleService) {
        this.jsonParser = jsonParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
    }

    @Override
    public void run(String... strings) throws Exception {

//        importSuppliers();
//        importParts();
//        importCars();
//        importCustomers();
//        importSales();
//       getOrderedCustomers();
//    getToyotaCars();
//        getLocalSuppliers();
//        getCarsInfoAndTheirParts();
 //       getTotalSaleByCustomer();
//        getTotalSaleByCustomer();
 //       getSalesWithDiscount();

    }


    public void importUsersFromXml(){

    }







    public void getSalesWithDiscount(){
        List<SalesWithDiscountDto> salesWithDiscountDto = this.saleService.findSaleInfo();

        this.jsonParser.writeObject(salesWithDiscountDto, "/src/main/resources/files.out/salesWithDiscount.json");
    }

    public void getTotalSaleByCustomer(){

        List<CustomersBoughtCarsView> customerWithCarsList = this.customerService.findCustomerAndTheirCars();

        this.jsonParser.writeObject(customerWithCarsList, "/src/main/resources/files.out/customersAndTheirCars.json");

    }

    public void getCarsInfoAndTheirParts(){
        List<CarAndPartsView> carAndPartsViews = this.carService.findAllCarsAndParts();

        this.jsonParser.writeObject(carAndPartsViews, "/src/main/resources/files.out/carsAndTheirParts.json");
    }

    public void getLocalSuppliers(){

        List<LocalSupplierViewDto> suppliers = this.supplierService.findAllLocalSupplier();

        this.jsonParser.writeObject(suppliers, "/src/main/resources/files.out/localSupplier.json");
    }

    public void getToyotaCars(){

        List<CarsFromToyotaViewDto> cars = this.carService.findAllToyotaCars();


            this.jsonParser.writeObject(cars, "/src/main/resources/files.out/toyotaCars.json");



    }

    public void getOrderedCustomers(){

       List<OrderedCustomersViewDto> customers = this.customerService.findAllOrderedByExperience();


            this.jsonParser.writeObject(customers, "/src/main/resources/files.out/orderedCustomer.json");



    }

    public void importSales(){

        Random random = new Random();

        List<Car> cars = this.carService.findAll();
        List<Customer>customers = this.customerService.findAll();
        List<Double> discounts = new ArrayList<>();
        discounts.add(0.0);
        discounts.add(0.05);
        discounts.add(0.1);
        discounts.add(0.15);
        discounts.add(0.20);
        discounts.add(0.30);
        discounts.add(0.40);
        discounts.add(0.50);


        for (int i = 0; i <20 ; i++) {

            SaleImportDto sale = new SaleImportDto();

            Car car = cars.get(random.nextInt(cars.size()));
            Customer customer = customers.get(random.nextInt(customers.size()));

            sale.setCar(car);
            sale.setCustomer(customer);
            sale.setDiscount(discounts.get(random.nextInt(discounts.size())));

            this.saleService.save(sale);

        }

    }

    public void importCustomers(){

        CustomerImportDto[] customers = this.jsonParser.getObject(CustomerImportDto[].class, "/files.in/customers.json");

        for (CustomerImportDto customer: customers) {

            this.customerService.save(customer);

        }


    }

    public void importCars(){

        Random random = new Random();

        CarImportDto[] cars = this.jsonParser
                .getObject(CarImportDto[].class, "/files.in/cars.json");

        List<Part> parts = this.partService.findAll();

        for (CarImportDto car:cars) {
            int listLenght = random.nextInt(20-10) + 10;

            Set<Part> partsForCurrentCar = new HashSet<>();

            for (int i = 0; i < listLenght ; i++) {
                Part part = parts.get(random.nextInt(parts.size()));

                if (partsForCurrentCar.contains(part)){
                    part = parts.get(random.nextInt(parts.size()));
                }

                partsForCurrentCar.add(part);

            }

            car.setParts(partsForCurrentCar);

            this.carService.save(car);
        }

    }



    public void importParts(){
        PartImportDto[] parts = this.jsonParser
                .getObject(PartImportDto[].class, "/files.in/parts.json");

        Random random = new Random();
        List<Supplier> suppliers = this.supplierService.findAll();


        for (PartImportDto part:parts) {

            part.setSupplier(suppliers.get(random.nextInt(suppliers.size())));

            this.partService.save(part);

        }

    }


    public void importSuppliers(){

        SupplierImportDto[] suppliers = this.jsonParser
                .getObject(SupplierImportDto[].class, "/files.in/suppliers.json");

        for (SupplierImportDto supplierImportDto: suppliers) {
            this.supplierService.save(supplierImportDto);
        }

    }

}
