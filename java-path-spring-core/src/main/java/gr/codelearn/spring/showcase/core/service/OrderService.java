package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Order;
import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.domain.User;

import java.util.List;

public interface OrderService {
	Order initiateOrder(User user);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	List<Order> getOrders();

	Order getOrder(Long id);

	void checkout(Order order);
}
