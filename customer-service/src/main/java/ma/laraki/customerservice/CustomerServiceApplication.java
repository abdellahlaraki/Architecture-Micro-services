package ma.laraki.customerservice;

import ma.laraki.customerservice.entities.Customer;
import ma.laraki.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
    // executer un traitement au démarage
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(
					Customer.builder().name("ahmed").email("med@gmail.com").build()
			);
			customerRepository.save(
					Customer.builder().name("yassine").email("yassine@gmail.com").build()
			);
			customerRepository.save(
					Customer.builder().name("imane").email("imane@gmail.com").build()
			);
		};
	}
}
