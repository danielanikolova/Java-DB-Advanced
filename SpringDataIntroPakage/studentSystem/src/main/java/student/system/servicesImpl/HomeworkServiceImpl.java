package student.system.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import student.system.entities.Homework;
import student.system.repositories.HomeworkRepository;
import student.system.services.HomeworkService;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class HomeworkServiceImpl implements HomeworkService<Homework, Long> {


    private final HomeworkRepository homeworkRepository;

    @Autowired
    public HomeworkServiceImpl(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }


    @Override
    public Homework findById(Long id) {
        return this.homeworkRepository.findOne(id);
    }

    @Override
    public void remove(Homework homework) {

        this.homeworkRepository.delete(homework);
    }

    @Override
    public List<Homework> findAll() {
        return this.homeworkRepository.findAll();
    }

    @Override
    public void save(Homework homework) {

        this.homeworkRepository.save(homework);
    }
}
