package br.com.cedran.persistence.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("br.com.cedran.persistence")
@EntityScan("br.com.cedran.domain")
@EnableJpaRepositories("br.com.cedran.persistence.repositories")
@EnableAutoConfiguration
public class Application {
}
