package ma.laraki.inventoryservice;

import ma.laraki.inventoryservice.entities.Product;
import ma.laraki.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
    // executer un traitement au moument d'éxecution
	@Bean
	CommandLineRunner start(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder().name("Computer1").price(1.25).quantity(50).build());
			productRepository.save(Product.builder().name("smartPhone").price(8.46).quantity(20).build());
			productRepository.save(Product.builder().name("Printer").price(10.78).quantity(58).build());
		};
	}
}
