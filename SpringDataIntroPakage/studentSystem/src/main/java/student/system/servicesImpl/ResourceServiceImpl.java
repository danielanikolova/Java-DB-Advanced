package student.system.servicesImpl;

import org.springframework.stereotype.Service;
import student.system.entities.Resource;
import student.system.repositories.ResourceRepository;
import student.system.services.ResourceService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ResourceServiceImpl implements ResourceService<Resource, Long> {

    private final ResourceRepository resourceRepository;

    public ResourceServiceImpl(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }


    @Override
    public Resource findById(Long id) {
        return this.resourceRepository.findOne(id);
    }

    @Override
    public void remove(Resource resource) {

        this.resourceRepository.delete(resource);
    }

    @Override
    public List<Resource> findAll() {
        return this.resourceRepository.findAll();
    }

    @Override
    public void save(Resource resource) {

        this.resourceRepository.save(resource);
    }
}
