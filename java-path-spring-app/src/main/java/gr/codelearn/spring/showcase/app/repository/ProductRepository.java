package gr.codelearn.spring.showcase.app.repository;

import gr.codelearn.spring.showcase.app.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
