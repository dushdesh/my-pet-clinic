package com.dushdesh.mypetclinic.services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    T save(T object);
    T delete(T object);

}
