package guru.springframework.sfgpc.repositories;

import guru.springframework.sfgpc.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
