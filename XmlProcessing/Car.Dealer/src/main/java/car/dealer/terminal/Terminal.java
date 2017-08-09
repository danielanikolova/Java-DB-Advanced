package car.dealer.terminal;


import car.dealer.dtoModels.jsonImportDtos.*;
import car.dealer.dtoModels.views.*;
import car.dealer.dtoModels.xmlImportDtos.CarImportXml;
import car.dealer.dtoModels.xmlImportDtos.CustomerImportXml;
import car.dealer.dtoModels.xmlImportDtos.PartsImportXml;
import car.dealer.dtoModels.xmlImportDtos.SupplierImportXml;
import car.dealer.dtoModels.xmlViewModels.*;
import car.dealer.dtoModels.xmlViewModels.Query4.CarsInfoXml;
import car.dealer.entities.*;
import car.dealer.io.JsonParser;
import car.dealer.io.XmlParser;
import car.dealer.repositories.PartRepository;
import car.dealer.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner{

    private final JsonParser jsonParser;
    private final SupplierService supplierService;
    private final PartService partService;
    private final CarService carService;
    private final CustomerService customerService;
    private  final SaleService saleService;
    private final XmlParser xmlParser;

    @Autowired
    public Terminal(JsonParser jsonParser, SupplierService supplierService, PartRepository partRepository, PartService partService, CarService carService, CustomerService customerService, SaleService saleService, XmlParser xmlParser) {
        this.jsonParser = jsonParser;
        this.supplierService = supplierService;
        this.partService = partService;
        this.carService = carService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... strings) throws Exception {

        //Json Commands

//        importSuppliers();
//        importParts();
//        importCars();
//        importCustomers();
//        importSales();
//        getOrderedCustomers();
//        getToyotaCars();
//        getLocalSuppliers();
//        getCarsInfoAndTheirParts();
//        getTotalSaleByCustomer();
//        getTotalSaleByCustomer();
//        getSalesWithDiscount();


        //Xml commands

//        importSuppliersXml();
//        importPartsXml();
//        importCarsXml();
//        importCustomerXml();
//        importSales();

//        getOrderedCustomersXml();
//        getCarsFromToyotaXml();
//        getLocalSuppliersXml();
//        getCarsInfo();
//        getTotalSalesXml();
//
//        getSalesXml();

    }


    //Xml methods

    public void getSalesXml(){

        SalesWithDiscountXml salesList = new SalesWithDiscountXml();

        salesList.setSales(this.saleService.findSaleInfo());

        try {
            this.xmlParser.writeObject(salesList, "src/main/resources/xml.out/salesWithDiscount.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getTotalSalesXml(){
        CustomersBoughtCarsXmlList currentList = this.customerService.findCustomersAndBoughtCarsXml();

        try {
            this.xmlParser.writeObject(currentList, "src/main/resources/xml.out/customersAndBoughtCars.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void getCarsInfo(){

        CarsInfoXml listOfCars = new CarsInfoXml();

        listOfCars.setCars(this.carService.getCarInfoXml());

        try {
            this.xmlParser.writeObject(listOfCars, "src/main/resources/xml.out/carsInfo.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getLocalSuppliersXml(){
        LocalSupplierListXml currentList = this.supplierService.getListFromSuppliersXml();

        try {
            this.xmlParser.writeObject(currentList, "src/main/resources/xml.out/localSuppliersXml.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getCarsFromToyotaXml(){

        CarsFromToyotaXml currentList = this.carService.findListFromCarsToyotaXml();

        try {
            this.xmlParser.writeObject(currentList, "src/main/resources/xml.out/toyotaCars.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getOrderedCustomersXml(){
        OrderedCustomerXml current = this.customerService.getOrderedCustomersXml();

        try {
            this.xmlParser.writeObject(current, "src/main/resources/xml.out/orderdCustomers.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importCustomerXml(){
        CustomerImportXml customerList = null;

        try {
            customerList = this.xmlParser.getObject(CustomerImportXml.class, "/xml/in/customers.xml");

            for (CustomerImportDto customer:customerList.getCustomers()) {
                this.customerService.save(customer);
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importCarsXml(){

        CarImportXml currentList = null;

        try {
            currentList = this.xmlParser.getObject(CarImportXml.class, "/xml/in/cars.xml");

            Random random = new Random();

            List<Part> parts = this.partService.findAll();


            for (CarImportDto car:currentList.getCars()) {

                Set<Part> randomList = new HashSet<>();

                for (int i = 0; i < random.nextInt(20-10)+10 ; i++) {
                    randomList.add(parts.get(random.nextInt(parts.size())));
                }

                car.setParts( randomList);
                this.carService.save(car);
            }


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importPartsXml(){
        PartsImportXml currentList = null;

        try {
            currentList = this.xmlParser.getObject(PartsImportXml.class, "/xml/in/parts.xml");
            Random random = new Random();

            List<Supplier> suppliers = this.supplierService.findAll();

            for (PartImportDto part:currentList.getPartsList()) {
                part.setSupplier(suppliers.get(random.nextInt(suppliers.size())));

               this.partService.save(part);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Transactional
    public  void  importSuppliersXml(){

        SupplierImportXml currentList = null;

        try {
            currentList = this.xmlParser.getObject(SupplierImportXml.class, "/xml/in/suppliers.xml");
            for (SupplierImportDto supplier:currentList.getSuppliers()) {
                this.supplierService.save(supplier);
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    //Json methods



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
