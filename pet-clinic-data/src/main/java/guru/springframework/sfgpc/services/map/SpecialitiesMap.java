package guru.springframework.sfgpc.services.map;

import guru.springframework.sfgpc.model.Speciality;
import guru.springframework.sfgpc.services.SpecialitiesService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialitiesMap extends AbstractMapService<Speciality, Long> implements SpecialitiesService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(final Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(final Speciality object) {
        super.delete(object);
    }

    @Override
    public void deletedById(final Long id) {
        super.deleteById(id);
    }
}
