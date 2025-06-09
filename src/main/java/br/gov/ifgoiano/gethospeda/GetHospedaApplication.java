package br.gov.ifgoiano.gethospeda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GetHospedaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetHospedaApplication.class, args);
    }

}