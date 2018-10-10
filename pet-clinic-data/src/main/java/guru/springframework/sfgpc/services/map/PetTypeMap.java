package guru.springframework.sfgpc.services.map;

import guru.springframework.sfgpc.model.PetType;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMap extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public void deletedById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(final PetType object) {
        return super.save(object);
    }

    @Override
    public PetType findById(final Long id) {
        return super.findById(id);
    }
}
