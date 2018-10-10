package guru.springframework.sfgpc.services.map;

import guru.springframework.sfgpc.model.Owner;
import guru.springframework.sfgpc.model.Pet;
import guru.springframework.sfgpc.services.OwnerService;
import guru.springframework.sfgpc.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            object.getPets().forEach(pet -> {
                if (pet.getPetType() != null) {
                    if (pet.getPetType().getId() == null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }
                } else {
                    throw new RuntimeException("Pet Type is required");
                }
                if (pet.getId() == null) {
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deletedById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return null;
    }
}
