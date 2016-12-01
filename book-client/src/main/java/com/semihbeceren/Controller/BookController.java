package com.semihbeceren.Controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.semihbeceren.Exception.NotFoundException;
import com.semihbeceren.Exception.ServiceNotRespondException;
import com.semihbeceren.RESTClient.Feign.BookFeignClient;
import com.semihbeceren.RESTClient.Holder.Book;
import com.semihbeceren.RESTClient.MessageWriter.SpringIntegrationWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Semih Beceren on 11/21/2016.
 *
 * Client uygulamamız için kontrolcü klasıdır.
 *
 * Hystrix circuitbreaker kullanır. (Tod*o-app-service uygulamamıza erişilemediği durumlarda Şalter görevi görür.)
 *
 */
@RestController
@RequestMapping(value = "books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final BookFeignClient bookFeignClient;
    private final SpringIntegrationWriter springIntegrationWriter;


    @Autowired
    public BookController(BookFeignClient bookFeignClient, SpringIntegrationWriter springIntegrationWriter) {
        this.bookFeignClient = bookFeignClient;
        this.springIntegrationWriter = springIntegrationWriter;
    }

    @HystrixCommand(fallbackMethod = "fallBackGetToDoes")
    @RequestMapping(method = RequestMethod.GET)
    public Collection<String> getToDoesName(){
        return this.bookFeignClient.getToDoes().getContent().stream().map(Book::getName).collect(Collectors.toList());
    }



    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Book> getToDo(@PathVariable("id") Long id){
        ResponseEntity<Book> responseEntity = null;

        try{
            responseEntity = this.bookFeignClient.getToDo(id);
        }catch (RuntimeException e){
            throw new NotFoundException();
        }

        return responseEntity;
    }


    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveToDo(@RequestBody Book book){
        try{
            this.bookFeignClient.saveToDo(book);
        }catch (RuntimeException e){
            this.springIntegrationWriter.write(book.getName());
            throw new ServiceNotRespondException();
        }
        return new ResponseEntity<Book>(HttpStatus.CREATED);
    }


    public Collection<String> fallBackGetToDoes(){
        return new ArrayList<>();
    }


}
