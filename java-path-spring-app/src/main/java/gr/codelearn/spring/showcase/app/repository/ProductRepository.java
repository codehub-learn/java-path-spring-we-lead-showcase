package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
	Product findBySerial(final String serial);
}
