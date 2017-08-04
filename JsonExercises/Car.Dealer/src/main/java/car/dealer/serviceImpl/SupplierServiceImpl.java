package car.dealer.serviceImpl;

import car.dealer.dtoModels.SupplierImportDto;
import car.dealer.entities.Supplier;
import car.dealer.io.ModelParser;
import car.dealer.repositories.SupplierRepository;
import car.dealer.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

    private SupplierRepository supplierRepository;

    @Autowired
    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public void save(SupplierImportDto supplierImportDto) {

        Supplier supplier = ModelParser.getInstance().map(supplierImportDto, Supplier.class);
        this.supplierRepository.saveAndFlush(supplier);

    }
}
