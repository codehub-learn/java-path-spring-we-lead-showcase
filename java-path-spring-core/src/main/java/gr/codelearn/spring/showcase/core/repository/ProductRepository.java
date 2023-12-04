package gr.codelearn.spring.showcase.core.repository;

import gr.codelearn.spring.showcase.core.domain.Product;

import java.util.List;

public interface ProductRepository {
	List<Product> getProducts();

	Product getProduct(String serial);
}
