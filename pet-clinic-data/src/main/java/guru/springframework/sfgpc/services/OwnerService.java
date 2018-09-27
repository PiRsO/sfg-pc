package guru.springframework.sfgpc.services;

import guru.springframework.sfgpc.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
