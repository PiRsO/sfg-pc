package guru.springframework.sfgpc.services.springdatajpa;

import guru.springframework.sfgpc.model.Owner;
import guru.springframework.sfgpc.repositories.OwnerRepository;
import guru.springframework.sfgpc.repositories.PetRepository;
import guru.springframework.sfgpc.services.OwnerService;
import guru.springframework.sfgpc.services.map.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeService petTypeService;

    public OwnerSDJpaService(final OwnerRepository ownerRepository, final PetRepository petRepository,
                             final PetTypeService petTypeService) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeService = petTypeService;
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {

        Set<Owner> owners = new HashSet<>();

        ownerRepository.findAll().forEach(owners::add);

        return owners;
    }

    @Override
    public Owner findById(final Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(final Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(final Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deletedById(final Long id) {
        ownerRepository.deleteById(id);
    }
}
