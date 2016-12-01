package com.semihbeceren.Util;

import com.semihbeceren.Model.Book;
import com.semihbeceren.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;


/**
 * Created by Semih Beceren on 17.11.2016.
 */
@Component
public class SampleDataCLR implements CommandLineRunner{

    private final BookRepository bookRepository;

    @Autowired
    public SampleDataCLR(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of(new Book("deneme1"), new Book("deneme2")).forEach(n -> bookRepository.save(n));
        bookRepository.findAll().forEach(System.out::println);
    }
}
