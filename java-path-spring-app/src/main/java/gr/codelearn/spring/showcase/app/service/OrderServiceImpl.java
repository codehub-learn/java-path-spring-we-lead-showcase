package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.model.Customer;
import gr.codelearn.spring.showcase.app.model.Order;
import gr.codelearn.spring.showcase.app.model.OrderItem;
import gr.codelearn.spring.showcase.app.model.PaymentMethod;
import gr.codelearn.spring.showcase.app.model.Product;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import gr.codelearn.spring.showcase.app.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
	private final OrderRepository orderRepository;

	@Override
	protected BaseRepository<Order, Long> getRepository() {
		return orderRepository;
	}

	@Override
	public Order initiateOrder(final Customer customer) {
		return Order.builder().customer(customer).build();
	}

	@Override
	public void addItem(final Order order, final Product product, final int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		boolean increasedQuantity = false;

		// If product is already contained in the order, don't add it again, just increase the quantity accordingly
		for (OrderItem oi : order.getOrderItems()) {
			if (oi.getProduct().getSerial().equals(product.getSerial())) {
				oi.setQuantity(oi.getQuantity() + quantity);
				increasedQuantity = true;
				break;
			}
		}

		if (!increasedQuantity) {
			order.getOrderItems().add(newOrderItem(product, quantity));
		}

		logger.trace("Product[{}] added to Order[{}]", product, order);
	}

	@Override
	public void updateItem(final Order order, final Product product, final int quantity) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		order.getOrderItems().add(newOrderItem(product, quantity));

		logger.trace("Product[{}] updated in Order[{}]", product, order);
	}

	@Override
	public void removeItem(final Order order, final Product product) {
		if (checkNullability(order, product)) {
			return;
		}

		order.getOrderItems().removeIf(oi -> oi.getProduct().getSerial().equals(product.getSerial()));
		logger.trace("Product[{}] removed from Order[{}]", product, order);
	}

	@Override
	public Order checkout(final Order order, final PaymentMethod paymentMethod) {
		if (!validate(order)) {
			logger.warn("Order should have customer, order items, and payment type defined before being able to " +
						"checkout the order.");
			return null;
		}

		// Set all order fields with proper values
		order.setPaymentMethod(paymentMethod);
		order.setSubmitDate(new Date());
		order.setCost(giveDiscounts(order));

		return create(order);

	}

	private boolean checkNullability(Order order, Product product) {
		if (order == null) {
			logger.warn("Order is null therefore it cannot be processed.");
			return true;
		}
		if (product == null) {
			logger.warn("Product is null therefore it cannot be added to an order.");
			return true;
		}
		return false;
	}

	private boolean validate(Order order) {
		return order != null && !order.getOrderItems().isEmpty() && order.getCustomer() != null;
	}

	private OrderItem newOrderItem(Product product, int quantity) {
		return OrderItem.builder().product(product).quantity(quantity).price(product.getPrice()).build();
	}

	private BigDecimal giveDiscounts(Order order) {
		float totalDiscount =
				order.getCustomer().getCustomerCategory().getDiscount() + order.getPaymentMethod().getDiscount();

		// Calculate original order cost
		BigDecimal originalCost = order.getOrderItems()
									   .stream()
									   .map(oi -> oi.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())))
									   .reduce(BigDecimal.ZERO, BigDecimal::add);

		// Apply discount
		BigDecimal finalCost = originalCost.multiply(BigDecimal.valueOf(1f - totalDiscount));

		logger.debug("Order[{}], originalCost: {}, discount: {}%, finalCost: {}.", order.getId(),
					 originalCost.setScale(2, RoundingMode.HALF_UP), Math.round(totalDiscount * 100),
					 finalCost.setScale(2, RoundingMode.HALF_UP));

		return finalCost;
	}
}
