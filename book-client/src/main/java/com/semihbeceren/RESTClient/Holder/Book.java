package com.semihbeceren.RESTClient.Holder;

/**
 * Created by Semih Beceren on 11/21/2016.
 *
 * Halihazırda Servisimizde bulunan entity tipinin kopyasıdır. Clint uygulamamız için bu tipi sadece tutucu olarak kullanacağız.
 *
 */
public class Book {

    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
