package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
}
