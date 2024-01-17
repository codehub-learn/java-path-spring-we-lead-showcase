package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.model.Customer;
import gr.codelearn.spring.showcase.app.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {
	private final CustomerRepository customerRepository;

	@Override
	protected JpaRepository<Customer, Long> getRepository() {
		return customerRepository;
	}

	@Override
	public Customer findByEmail(final String email) {
		return customerRepository.findByEmail(email);
	}
}
