package tokyo.boblennon.mwc22back.infrastructure.developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tokyo.boblennon.mwc22back.domain.developer.DevRepositoryRead;
import tokyo.boblennon.mwc22back.domain.developer.DevRepositoryWrite;
import tokyo.boblennon.mwc22back.domain.developer.Developer;

@Service
public class DevRepositoryImp implements DevRepositoryWrite, DevRepositoryRead {

    private final DevRepositoryJPA devRepositoryJPA;

    @Autowired
    public DevRepositoryImp(final DevRepositoryJPA devRepositoryJPA) {
        this.devRepositoryJPA = devRepositoryJPA;
    }

    @Override
    public List<Developer> getAll() {
        return this.devRepositoryJPA.findAll();
    }

    @Override
    public void add(Developer developer) {
        this.devRepositoryJPA.save(developer);
    }

    @Override
    public void addAll(List<Developer> devs) {
       this.devRepositoryJPA.saveAll(devs);
    }

}
