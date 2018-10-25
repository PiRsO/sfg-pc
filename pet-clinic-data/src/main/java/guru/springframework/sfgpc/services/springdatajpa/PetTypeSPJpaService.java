package guru.springframework.sfgpc.services.springdatajpa;

import guru.springframework.sfgpc.model.PetType;
import guru.springframework.sfgpc.repositories.PetTypeRepository;
import guru.springframework.sfgpc.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSPJpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSPJpaService(final PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(final Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(final PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(final PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deletedById(final Long id) {
        petTypeRepository.deleteById(id);
    }
}
