package com.semihbeceren.Model;

import javax.persistence.MappedSuperclass;

/**
 * Created by Semih Beceren on 17.11.2016.
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
