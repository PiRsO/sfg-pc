package guru.springframework.sfgpc.services.map;

import guru.springframework.sfgpc.model.BaseEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new ConcurrentHashMap<>();

    Set<T> findAll() {
        Set<T> all = new HashSet<>();
        map.values().forEach(t -> all.add(t));
        return all;
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }

        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet()
                .removeIf(entry -> entry.getValue()
                        .equals(object));
    }

    private Long getNextId() {
        return map.isEmpty() ? 1L : Collections.max(map.keySet()) + 1;
    }
}
