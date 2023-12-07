package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Order;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class OrderRepositoryImpl extends BaseRepositoryImpl<Order> implements OrderRepository {
	private final ConcurrentHashMap<Long, Order> storage = new ConcurrentHashMap<>();
	private final AtomicLong sequence = new AtomicLong(0);

	@Override
	protected ConcurrentHashMap<Long, Order> getStorage() {
		return storage;
	}

	@Override
	protected AtomicLong getSequence() {
		return sequence;
	}
}
