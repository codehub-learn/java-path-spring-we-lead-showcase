package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.model.Customer;
import gr.codelearn.spring.showcase.app.model.Order;
import gr.codelearn.spring.showcase.app.model.PaymentMethod;
import gr.codelearn.spring.showcase.app.model.Product;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesAndCostPerCustomer;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderService extends BaseService<Order, Long> {
	Order initiateOrder(Customer customer);

	void addItem(Order order, Product product, int quantity);

	void updateItem(Order order, Product product, int quantity);

	void removeItem(Order order, Product product);

	Order checkout(Order order, PaymentMethod paymentMethod);

	Optional<Order> findWithCustomer(Long id);

	Optional<Order> findWithAllAssociations(Long id);

	List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer();

	List<PurchasesAndCostPerCustomer> findTotalNumberAndCostOfPurchasesPerCustomerCategory();
}
