package com.semihbeceren.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Semih Beceren on 11/22/2016.
 */
@ResponseStatus(value= HttpStatus.SERVICE_UNAVAILABLE, reason="Servis Yanıt Vermiyor.İşlem sıraya alındı ve servisle bağlantı kurulduğunda gerçekleştirilecek.")
public class ServiceNotRespondException extends RuntimeException {}
