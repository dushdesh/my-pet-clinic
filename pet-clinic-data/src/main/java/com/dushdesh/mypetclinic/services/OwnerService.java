package com.dushdesh.mypetclinic.services;

import com.dushdesh.mypetclinic.models.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
