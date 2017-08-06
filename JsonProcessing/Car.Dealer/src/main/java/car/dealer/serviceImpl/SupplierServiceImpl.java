package car.dealer.serviceImpl;

import car.dealer.dtoModels.ImportDtos.SupplierImportDto;
import car.dealer.dtoModels.views.LocalSupplierViewDto;
import car.dealer.entities.Supplier;
import car.dealer.io.ModelParser;
import car.dealer.repositories.SupplierRepository;
import car.dealer.services.SupplierService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService{

    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }


    @Override
    public void save(SupplierImportDto supplierImportDto) {
        Supplier supplier = ModelParser.getInstance()
                .map(supplierImportDto, Supplier.class);
        this.supplierRepository.saveAndFlush(supplier);
    }

    @Override
    public List<Supplier> findAll() {
        List<Supplier> suppliers = this.supplierRepository.findAll();

        return suppliers;
    }

    @Override
    public List<LocalSupplierViewDto> findAllLocalSupplier() {

        List<Supplier> suppliers = this.supplierRepository.findAllLocalSuppliers();

        List<LocalSupplierViewDto> result = new ArrayList<>();

        for (Supplier supplier: suppliers) {
            LocalSupplierViewDto current = ModelParser.getInstance()
                    .map(supplier, LocalSupplierViewDto.class);

            result.add(current);
        }


        return result;
    }
}
