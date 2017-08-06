package car.dealer.serviceImpl;

import car.dealer.dtoModels.ImportDtos.CustomerImportDto;

import car.dealer.dtoModels.views.CustomersBoughtCarsView;
import car.dealer.dtoModels.views.OrderedCustomersViewDto;
import car.dealer.entities.Customer;
import car.dealer.io.ModelParser;
import car.dealer.repositories.CustomerRepository;
import car.dealer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(CustomerImportDto customerImportDto) {
        Customer customer = ModelParser.getInstance().map(customerImportDto, Customer.class);

        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = this.customerRepository.findAll();

        return customers;
    }

    @Override
    public List<OrderedCustomersViewDto> findAllOrderedByExperience() {
        List<Customer> customers = this.customerRepository.getAllOrderedByExperience();

        List<OrderedCustomersViewDto> result = new ArrayList<>();

        for (Customer customer:customers) {
            OrderedCustomersViewDto orderedCustomersViewDto = ModelParser.getInstance()
                    .map(customer, OrderedCustomersViewDto.class);

            result.add(orderedCustomersViewDto);
        }

        return result;
    }

    @Override
    public List<CustomersBoughtCarsView> findCustomerAndTheirCars() {

        List<Object[]> customers = this.customerRepository.findCustomersBoughtCars();

        List<CustomersBoughtCarsView> customerView = new ArrayList<>();

        for (Object[] object:customers) {

            CustomersBoughtCarsView current = new CustomersBoughtCarsView();

            String name = object[0].toString();
            int totalCars = Integer.parseInt(object[1].toString());
            BigDecimal totalPrice = (BigDecimal) object[2];

            current.setFullName(name);
            current.setBoughtCars(totalCars);
            current.setSpentMoney(totalPrice);

            customerView.add(current);
        }


        return customerView;
    }
}
