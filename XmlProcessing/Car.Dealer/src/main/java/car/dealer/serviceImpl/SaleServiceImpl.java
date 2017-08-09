package car.dealer.serviceImpl;

import car.dealer.dtoModels.jsonImportDtos.SaleImportDto;
import car.dealer.dtoModels.views.CarInfoView;
import car.dealer.dtoModels.views.SalesWithDiscountDto;
import car.dealer.entities.Car;
import car.dealer.entities.Sale;
import car.dealer.io.ModelParser;
import car.dealer.repositories.CarRepository;
import car.dealer.repositories.SaleRepository;
import car.dealer.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service@Transactional
public class SaleServiceImpl implements SaleService{

    private SaleRepository saleRepository;
    private CarRepository carRepository;

    @Autowired
    public SaleServiceImpl(SaleRepository saleRepository, CarRepository carRepository) {
        this.saleRepository = saleRepository;
        this.carRepository = carRepository;
    }

    @Override
    public void save(SaleImportDto saleImportDto) {

        Sale sale = ModelParser.getInstance().map(saleImportDto, Sale.class);

        this.saleRepository.saveAndFlush(sale);

    }

    @Override
    public List<SalesWithDiscountDto> findSaleInfo() {

        List<Object[]>sales =this.saleRepository.findSalesWithDiscounts();

        List <SalesWithDiscountDto> salesWithDiscountDtos = new ArrayList<>();

        for (Object[] object: sales){

            Long carId = Long.parseLong(object[0].toString());
            String name = object[1].toString();
            Double discount = Double.parseDouble(object[2].toString());
            BigDecimal price = (BigDecimal) object[3];
            BigDecimal priceWithDiscount = new BigDecimal("0");

            if (discount == null){
                priceWithDiscount = price;
            }
            else {
                BigDecimal disc = BigDecimal.valueOf(discount);

                priceWithDiscount =price.subtract(price.multiply(disc));

            }

            SalesWithDiscountDto salesWithDiscountDto = new SalesWithDiscountDto();

            Car car = this.carRepository.findOne(carId);

            salesWithDiscountDto.setPrice(price);
            salesWithDiscountDto.setCustomerName(name);
            salesWithDiscountDto.setDiscount(discount);
            salesWithDiscountDto.setPriceWithDiscount(priceWithDiscount);

            CarInfoView carInfoView = ModelParser.getInstance().map(car, CarInfoView.class);

            salesWithDiscountDto.setCar(carInfoView);

            salesWithDiscountDtos.add(salesWithDiscountDto);

        }

        return salesWithDiscountDtos;
    }
}
