package car.dealer.services;


import car.dealer.dtoModels.ImportDtos.CustomerImportDto;
import car.dealer.dtoModels.views.CustomersBoughtCarsView;
import car.dealer.dtoModels.views.OrderedCustomersViewDto;
import car.dealer.entities.Customer;

import java.util.List;

public interface CustomerService {

    void save(CustomerImportDto customerImportDto);

    List<Customer> findAll();

    List<OrderedCustomersViewDto> findAllOrderedByExperience();

    List<CustomersBoughtCarsView> findCustomerAndTheirCars();
}
