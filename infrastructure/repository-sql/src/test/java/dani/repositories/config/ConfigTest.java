package dani.repositories.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan("dani.repositories.mappers")
@EntityScan("dani.repositories.models")
@EnableJpaRepositories("dani.repositories")
@SpringBootApplication
public abstract class ConfigTest {

}
