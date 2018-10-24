package guru.springframework.sfgpc.repositories;

import guru.springframework.sfgpc.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
