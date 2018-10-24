package guru.springframework.sfgpc.repositories;

import guru.springframework.sfgpc.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
