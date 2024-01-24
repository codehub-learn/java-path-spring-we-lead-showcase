package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Order;
import gr.codelearn.spring.showcase.app.transfer.KeyValue;
import gr.codelearn.spring.showcase.app.transfer.PurchasesAndCostPerCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	@Query
	Optional<Order> findWithCustomer(Long id);

	@Query
	Optional<Order> findWithAllAssociations(Long id);

	@Query
	List<KeyValue<String, BigDecimal>> findAverageOrderCostPerCustomer();

	@Query(value = "${}", nativeQuery = true)
	List<PurchasesAndCostPerCustomer> findTotalNumberAndCostOfPurchasesPerCustomerCategory();
}
