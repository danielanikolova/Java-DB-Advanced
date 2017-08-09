package car.dealer.services;


import car.dealer.dtoModels.jsonImportDtos.CustomerImportDto;
import car.dealer.dtoModels.views.CustomersBoughtCarsView;
import car.dealer.dtoModels.views.OrderedCustomersViewDto;
import car.dealer.dtoModels.xmlViewModels.CustomersBoughtCarsXmlList;
import car.dealer.dtoModels.xmlViewModels.OrderedCustomerViewXml;
import car.dealer.dtoModels.xmlViewModels.OrderedCustomerXml;
import car.dealer.entities.Customer;

import java.util.List;

public interface CustomerService {

    void save(CustomerImportDto customerImportDto);

    List<Customer> findAll();

    List<OrderedCustomersViewDto> findAllOrderedByExperience();

    List<CustomersBoughtCarsView> findCustomerAndTheirCars();

    //Query 1 – Ordered Customers - Xml

    List<OrderedCustomerViewXml>findAllOrderedByExperienceXml();

    OrderedCustomerXml getOrderedCustomersXml();

    CustomersBoughtCarsXmlList findCustomersAndBoughtCarsXml();
}
