package com.semihbeceren;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 *
 * CircuitBreaker konusuna ToDoController içerisinde bahsedildi
 * FeignClients konusuna BookFeignClient içerisinde bahsedildi.
 *
 * SpringBootApplication birden fazla notasyonun birleşiminin karşılığıdır. @Configuration @EnableAutoConfiguration @ComponentScan notasyonlarının paketlenmiş halidir.
 *
 * EnableZuulProxy - Normalde her servis kendi çıkış portu üzerinden yayın yapmaktadır. Ancak eureka sunucumuza kayıt ettirilen mikroservisleri tek port üzerinden erişilebilir kılar.
 *
 * EnableDiscoveryClient - Mikroservisimizi eureka server üzerine kayıt ettiriyoruz.
 */
@EnableResourceServer
@IntegrationComponentScan
@EnableBinding(Source.class)
@EnableCircuitBreaker
@EnableFeignClients
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class BookClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookClientApplication.class, args);
	}
}
