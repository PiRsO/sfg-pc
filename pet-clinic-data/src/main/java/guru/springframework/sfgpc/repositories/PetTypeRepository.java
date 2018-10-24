package guru.springframework.sfgpc.repositories;

import guru.springframework.sfgpc.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
