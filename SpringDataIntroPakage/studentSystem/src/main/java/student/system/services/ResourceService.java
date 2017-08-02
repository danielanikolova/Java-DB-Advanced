package student.system.services;


import java.util.List;

public interface ResourceService<Resource, Long>{


    Resource findById(Long id);

    void remove(Resource resource);

    List<Resource> findAll();

    void save(Resource resource);
}
