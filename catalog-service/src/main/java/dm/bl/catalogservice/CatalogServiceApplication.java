package dm.bl.catalogservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ProductRepository.class)
public class CatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner initdb(ProductRepository repository){
		return args -> {
			repository.insert(new Product( null, "Boot", "new", 12.22));
			repository.insert(new Product( null,"Hat", "new", 15.22));
			repository.insert(new Product( null, "T-shirt", "new", 18.22));
		};
	}
}
