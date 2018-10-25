package guru.springframework.sfgpc.services.map;

import guru.springframework.sfgpc.model.Visit;
import guru.springframework.sfgpc.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default, map"})
public class VisitMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deletedById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(final Visit visit) {

        if (visit == null || visit.getPet().getId() == null ||visit.getPet().getOwner() == null
                || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(final Long id) {
        return super.findById(id);
    }
}
