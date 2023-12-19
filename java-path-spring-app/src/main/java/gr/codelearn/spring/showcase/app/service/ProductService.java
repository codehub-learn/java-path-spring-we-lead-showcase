package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.model.Category;
import gr.codelearn.spring.showcase.app.model.Product;

public interface ProductService extends BaseService<Product, Long> {
	Product findBySerial(String serial);

	Product create(Product product, Long categoryId);
}
