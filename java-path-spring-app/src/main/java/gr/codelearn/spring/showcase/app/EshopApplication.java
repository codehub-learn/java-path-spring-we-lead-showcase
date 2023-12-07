package gr.codelearn.spring.showcase.app;

import gr.codelearn.spring.showcase.app.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);

		var customer = new Customer();
		customer.setEmail("some@gmailx.com");

		var customerViaBuilder = Customer.builder().lastname("Someone").firstname("Me").build();

	}
}
