package guru.springframework.sfgpc.repositories;

import guru.springframework.sfgpc.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
