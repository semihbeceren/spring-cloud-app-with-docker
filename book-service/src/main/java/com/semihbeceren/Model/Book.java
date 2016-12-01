package com.semihbeceren.Model;

import javax.persistence.Entity;

/**
 * Created by Semih Beceren on 17.11.2016.
 */
@Entity
public class Book extends NamedEntity{

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                '}';
    }
}
