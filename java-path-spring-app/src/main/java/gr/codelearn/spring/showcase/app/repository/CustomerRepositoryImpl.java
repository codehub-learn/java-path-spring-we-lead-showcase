package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {
	private final ConcurrentHashMap<Long, Customer> storage = new ConcurrentHashMap<>();
	private final AtomicLong sequence = new AtomicLong(0);

	@Override
	protected ConcurrentHashMap<Long, Customer> getStorage() {
		return storage;
	}

	@Override
	protected AtomicLong getSequence() {
		return sequence;
	}

	@Override
	public Customer findByEmail(final String email) {
		return storage.values()
					  .stream()
					  .filter(c -> email.equalsIgnoreCase(c.getEmail()))
					  .findFirst()
					  .orElse(null);
	}
}
