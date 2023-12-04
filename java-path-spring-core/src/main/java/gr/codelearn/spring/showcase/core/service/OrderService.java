package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Order;
import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.domain.User;

import java.util.List;

public interface OrderService {
	Order initiateOrder(User user);

	List<Order> getOrders();

	Order getOrder(Long id);

	void addItem(Order Order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	void checkout(Order order);
}
