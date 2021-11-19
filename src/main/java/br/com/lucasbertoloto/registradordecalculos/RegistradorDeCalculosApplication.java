package br.com.lucasbertoloto.registradordecalculos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RegistradorDeCalculosApplication {

    public static void main(String[] args) {
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
        SpringApplication.run(RegistradorDeCalculosApplication.class, args);
    }
}
