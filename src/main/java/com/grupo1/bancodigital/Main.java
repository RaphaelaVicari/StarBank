package com.grupo1.bancodigital;

import com.grupo1.bancodigital.model.cliente.CategoriaEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        CategoriaEntity e1 = new CategoriaEntity();

        SpringApplication.run(Main.class, args);
    }

}
