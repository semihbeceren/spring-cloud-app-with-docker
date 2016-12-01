package com.semihbeceren.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created by Semih Beceren on 11/22/2016.
 */
@MappedSuperclass
abstract class NamedEntity extends BaseEntity{
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
