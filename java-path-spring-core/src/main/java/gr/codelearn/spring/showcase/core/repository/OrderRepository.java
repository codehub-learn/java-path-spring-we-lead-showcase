package gr.codelearn.spring.showcase.core.repository;

import gr.codelearn.spring.showcase.core.domain.Order;

import java.util.List;

public interface OrderRepository {
	List<Order> getOrders();

	Order getOrder(Long id);

	boolean save(Order order);
}
