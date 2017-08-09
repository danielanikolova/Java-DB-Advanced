package car.dealer.serviceImpl;

import car.dealer.dtoModels.jsonImportDtos.SupplierImportDto;
import car.dealer.dtoModels.views.LocalSupplierViewDto;
import car.dealer.dtoModels.xmlImportDtos.SupplierImportXml;
import car.dealer.dtoModels.xmlViewModels.LocalSupplierListXml;
import car.dealer.dtoModels.xmlViewModels.LocalSupplierViewXml;
import car.dealer.entities.Part;
import car.dealer.entities.Supplier;
import car.dealer.io.ModelParser;
import car.dealer.repositories.SupplierRepository;
import car.dealer.services.SupplierService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<LocalSupplierViewXml> findAllLocalSupplierXml() {

        List<Supplier> suppliers = this.supplierRepository.findAllLocalSuppliers();

        List<LocalSupplierViewXml> resultList = new ArrayList<>();

        for (Supplier supplier: suppliers) {
            LocalSupplierViewXml current = ModelParser.getInstance()
                    .map(supplier, LocalSupplierViewXml.class);

            int partsListCount = supplier.getParts().size();

            current.setPartsCount(partsListCount);

            resultList.add(current);
        }


        return resultList;
    }


    @Override
    public LocalSupplierListXml getListFromSuppliersXml() {

        List<LocalSupplierViewXml> suppliers = this.findAllLocalSupplierXml();

        LocalSupplierListXml currentList = new LocalSupplierListXml();
        currentList.setSuppliers(suppliers);

        return currentList;
    }


}
