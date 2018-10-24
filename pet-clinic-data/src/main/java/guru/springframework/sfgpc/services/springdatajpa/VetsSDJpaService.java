package guru.springframework.sfgpc.services.springdatajpa;

import guru.springframework.sfgpc.model.Vet;
import guru.springframework.sfgpc.repositories.VetRepository;
import guru.springframework.sfgpc.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajps")
public class VetsSDJpaService implements VetService {

    private final VetRepository vetRepository;

    public VetsSDJpaService(final VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(final Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(final Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(final Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deletedById(final Long id) {
        vetRepository.deleteById(id);
    }
}
