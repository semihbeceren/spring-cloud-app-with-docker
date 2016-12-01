package com.semihbeceren.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Semih Beceren on 11/22/2016.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Sayfa Bulunamadı.")
public class NotFoundException extends RuntimeException {}
