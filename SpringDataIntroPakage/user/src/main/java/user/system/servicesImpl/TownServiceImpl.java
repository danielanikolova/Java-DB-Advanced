package user.system.servicesImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.system.entities.Town;
import user.system.repositories.TownRepository;
import user.system.servicesInterf.TownServiceInterf;

import javax.transaction.Transactional;


@Service
@Transactional
public class TownServiceImpl implements TownServiceInterf{

    private final TownRepository townRepository;

    @Autowired
    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }


    @Override
    public void persist(Town town) {

        this.townRepository.save(town);
    }
}
