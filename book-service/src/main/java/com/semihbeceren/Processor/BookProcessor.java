package com.semihbeceren.Processor;

import com.semihbeceren.Model.Book;
import com.semihbeceren.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by Semih Beceren on 11/22/2016.
 *
 * Gelen input channel ile bind edilen mesaja integration ile endpoint oluşturma işlemi.
 * Gelen mesaja kayıt işlemi uygulanıyor.
 *
 */
@MessageEndpoint
public class BookProcessor {

    private final BookRepository bookRepository;

    @Autowired
    public BookProcessor(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @ServiceActivator(inputChannel = "input")
    public void onNewTodo(String todoName){
        this.bookRepository.save(new Book(todoName));
    }

}
