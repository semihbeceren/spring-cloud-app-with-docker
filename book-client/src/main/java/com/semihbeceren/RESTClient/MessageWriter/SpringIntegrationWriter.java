package com.semihbeceren.RESTClient.MessageWriter;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by Semih Beceren on 11/21/2016.
 */
@MessagingGateway
public interface SpringIntegrationWriter {
    @Gateway(requestChannel = "output")
    void write(String str);
}
