package com.semihbeceren.Util;

import com.semihbeceren.Model.Account;
import com.semihbeceren.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * Created by Semih Beceren on 11/22/2016.
 */
@Component
public class SampleDataCLR implements CommandLineRunner{

    private final AccountRepository accountRepository;

    @Autowired
    public SampleDataCLR(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Stream.of("semih,password")
                .map(x -> x.split(","))
                .forEach(tuple -> this.accountRepository.save(new Account(tuple[0], tuple[1])));

        this.accountRepository.findAll().forEach(System.out::println);
    }


}
