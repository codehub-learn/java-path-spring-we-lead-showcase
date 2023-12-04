package gr.codelearn.spring.showcase.core.repository.pooling;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.domain.Order;
import gr.codelearn.spring.showcase.core.repository.DataRepository;
import gr.codelearn.spring.showcase.core.repository.OrderRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Primary
@ConditionalOnClass(name = "gr.codelearn.spring.showcase.core.undefined.DataSource")
public class OrderRepositoryImplSQLWithConnectionPooling extends BaseComponent
		implements OrderRepository, DataRepository {
	@Override
	public void logData(String command) {
		// Code for logging data
		logger.info("{}: logging data", this.getClass().getName());
	}

	@Override
	public List<Order> getOrders() {
		// Code for getting all orders
		logger.info("{}: fetching all orders", this.getClass().getName());
		return Collections.emptyList();
	}

	@Override
	public Order getOrder(Long id) {
		// Code for getting an order by id
		logger.info("{}: fetching  order by id", this.getClass().getName());
		return null;
	}

	@Override
	public boolean save(Order order) {
		// Code for saving an order
		logger.info("{}: saving order", this.getClass().getName());
		return true;
	}
}
