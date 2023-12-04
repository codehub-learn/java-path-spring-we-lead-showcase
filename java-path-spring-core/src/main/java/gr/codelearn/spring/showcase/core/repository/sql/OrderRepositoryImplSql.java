package gr.codelearn.spring.showcase.core.repository.sql;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.domain.Order;
import gr.codelearn.spring.showcase.core.repository.DataRepository;
import gr.codelearn.spring.showcase.core.repository.OrderRepository;
import gr.codelearn.spring.showcase.core.repository.pooling.OrderRepositoryImplSQLWithConnectionPooling;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Qualifier("sql")
@ConditionalOnMissingBean(OrderRepositoryImplSQLWithConnectionPooling.class)
public class OrderRepositoryImplSql extends BaseComponent implements OrderRepository, DataRepository {
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
