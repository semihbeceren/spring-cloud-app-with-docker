package com.semihbeceren.RESTClient.Feign;

import com.semihbeceren.RESTClient.Holder.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Semih Beceren on 11/21/2016.
 *
 * Netflix Feign REST Client kullanarak Rest Servisimizden Verileri okuyoruz.
 *
 */
@FeignClient("book-service")
public interface BookFeignClient {

    //Rotalar REST servisi ile birabir uymalıdır.
    @RequestMapping(method = RequestMethod.GET, value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    Resources<Book> getToDoes();

    @RequestMapping(method = RequestMethod.GET, value = "/books/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Book> getToDo(@PathVariable("id") Long id);

    @RequestMapping(method = RequestMethod.POST, value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Book> saveToDo(@RequestBody Book book);
}
