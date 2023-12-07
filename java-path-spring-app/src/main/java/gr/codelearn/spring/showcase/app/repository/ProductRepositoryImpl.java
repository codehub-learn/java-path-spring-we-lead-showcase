package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Product;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepositoryImpl extends BaseRepositoryImpl<Product> implements ProductRepository {
	private final ConcurrentHashMap<Long, Product> storage = new ConcurrentHashMap<>();
	private final AtomicLong sequence = new AtomicLong(0);

	@Override
	protected ConcurrentHashMap<Long, Product> getStorage() {
		return storage;
	}

	@Override
	protected AtomicLong getSequence() {
		return sequence;
	}

	@Override
	public Product findBySerial(final String serial) {
		return storage.values()
					  .stream()
					  .filter(c -> serial.equalsIgnoreCase(c.getSerial()))
					  .findFirst()
					  .orElse(null);
	}
}
