package car.dealer.serviceImpl;

import car.dealer.dtoModels.jsonImportDtos.PartImportDto;
import car.dealer.dtoModels.views.PartInfoView;
import car.dealer.dtoModels.xmlViewModels.Query4.PartsListXml;
import car.dealer.entities.Part;
import car.dealer.io.ModelParser;
import car.dealer.repositories.PartRepository;
import car.dealer.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PartServiceImpl implements PartService{

    private PartRepository partRepository;

    @Autowired
    public PartServiceImpl(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public void save(PartImportDto partImportDto) {
        Part part = ModelParser.getInstance().map(partImportDto, Part.class);

        this.partRepository.saveAndFlush(part);
    }

    @Override
    public List<Part> findAll() {

        List<Part> parts = this.partRepository.findAll();
        return parts;
    }


    @Override
    public PartInfoView getPartNameAndPrice(Long id) {
        Part part = this.partRepository.findOne(id);

        PartInfoView partInfoView = ModelParser.getInstance().map(part, PartInfoView.class);

        return partInfoView;

    }


}
