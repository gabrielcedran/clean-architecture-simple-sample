package br.com.cedran.presentation;

import br.com.cedran.application.configuration.EnableApplicationLayer;
import br.com.cedran.persistence.configuration.EnablePersistenceLayer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableApplicationLayer
@EnablePersistenceLayer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
