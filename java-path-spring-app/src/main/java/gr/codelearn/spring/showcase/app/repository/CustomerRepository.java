package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
	Customer findByEmail(String email);
}
