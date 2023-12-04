package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Order;
import gr.codelearn.spring.showcase.core.domain.OrderItem;
import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.domain.User;
import gr.codelearn.spring.showcase.core.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	public Order initiateOrder(User user) {
		return Order.builder().user(user).build();
	}

	@Override
	public List<Order> getOrders() {
		return orderRepository.getOrders();
	}

	@Override
	public Order getOrder(Long id) {
		return orderRepository.getOrder(id);
	}

	@Override
	public void addItem(Order order, Product product, int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		boolean increasedQuantity = false;

		// If product is already contained in the order, don't add it again, just increase the quantity accordingly
		for (OrderItem oi : order.getOrderItems()) {
			if (oi.getSerial().equals(product.getSerial())) {
				oi.setQuantity(oi.getQuantity() + quantity);
				increasedQuantity = true;
				break;
			}
		}

		if (!increasedQuantity) {
			order.getOrderItems().add(OrderItem.builder().serial(product.getSerial()).quantity(quantity)
											   .price(product.getPrice()).build());
		}

		logger.debug("Product[{}] added to Order[{}]", product, order);
	}

	private boolean checkNullability(Order order, Product product) {
		if (order == null) {
			logger.warn("Order is null.");
			return true;
		}
		if (product == null) {
			logger.warn("Product is null.");
			return true;
		}
		return false;
	}

	@Override
	public void updateItem(Order order, Product product, int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getSerial().equals(product.getSerial()));
		order.getOrderItems().add(OrderItem.builder().serial(product.getSerial()).quantity(quantity)
										   .price(product.getPrice()).build());

		logger.debug("Product[{}] updated in Order[{}]", product, order);
	}

	@Override
	public void removeItem(Order order, Product product) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getSerial().equals(product.getSerial()));
		logger.debug("Product[{}] removed from Order[{}]", product, order);
	}

	@Override
	public void checkout(Order order) {
		if (!validate(order)) {
			logger.warn("Order should have customer, order items, and payment type defined before being able to be " +
						"checkout the order.");
			return;
		}

		// Set all order fields with proper values
		order.setSubmitDate(new Date());
		order.setCost(order.getCost());

		orderRepository.save(order);
	}

	private boolean validate(Order order) {
		return order != null && !order.getOrderItems().isEmpty() && order.getUser() != null;
	}
}
