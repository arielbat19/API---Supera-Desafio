package br.com.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication
public class BancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BancoApplication.class, args);
    }

}
