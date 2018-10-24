package guru.springframework.sfgpc.services.springdatajpa;

import guru.springframework.sfgpc.model.Speciality;
import guru.springframework.sfgpc.repositories.SpecialtyRepository;
import guru.springframework.sfgpc.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialitySDJpaService implements SpecialityService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialitySDJpaService(final SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialtyRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(final Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(final Speciality object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(final Speciality object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deletedById(final Long id) {
        specialtyRepository.deleteById(id);
    }
}
