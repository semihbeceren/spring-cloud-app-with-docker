package com.semihbeceren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


/**
 * Ayar sunucusudur. Application properties üzerinden verilen klasör yolu içerisindeki ayarları belirlenen port üzerinden JSON çıktısı olarak yayınlar.
 */

@EnableConfigServer
@SpringBootApplication
public class ConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServiceApplication.class, args);
	}
}
