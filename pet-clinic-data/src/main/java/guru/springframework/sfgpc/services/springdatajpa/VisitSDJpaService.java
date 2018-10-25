package guru.springframework.sfgpc.services.springdatajpa;

import guru.springframework.sfgpc.model.Visit;
import guru.springframework.sfgpc.repositories.VisitRepository;
import guru.springframework.sfgpc.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJpaService(final VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(final Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(final Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(final Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deletedById(final Long id) {
        visitRepository.deleteById(id);
    }
}
