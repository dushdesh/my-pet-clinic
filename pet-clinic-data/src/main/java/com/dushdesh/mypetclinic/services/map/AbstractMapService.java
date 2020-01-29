package com.dushdesh.mypetclinic.services.map;

import com.dushdesh.mypetclinic.models.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    private Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(Long id) {
        return map.get(id);
    }

    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
            return object;
        } else {
            throw new RuntimeException("Null object cannot be saved!");
        }
    }

    T deleteById(ID id) {
        T object = map.get(id);
        map.remove(id);
        return object;
    }

    private Long getNextId() {
        if (map.isEmpty()) {
            return 0L;
        }
        return Collections.max(map.keySet()) + 1;
    }

}
