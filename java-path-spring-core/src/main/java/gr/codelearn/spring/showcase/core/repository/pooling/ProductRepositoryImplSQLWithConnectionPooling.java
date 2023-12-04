package gr.codelearn.spring.showcase.core.repository.pooling;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.repository.DataRepository;
import gr.codelearn.spring.showcase.core.repository.ProductRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Primary
@ConditionalOnClass(name = "gr.codelearn.spring.showcase.core.undefined.DataSource")
public class ProductRepositoryImplSQLWithConnectionPooling extends BaseComponent
		implements ProductRepository, DataRepository {
	@Override
	public void logData(String command) {
		// Code for logging data
		logger.info("{}: logging data", this.getClass().getName());
	}

	@Override
	public List<Product> getProducts() {
		// Code for getting all products
		logger.info("{}: fetching all products", this.getClass().getName());
		return Collections.emptyList();
	}

	@Override
	public Product getProduct(String serial) {
		// Code for getting a product by its serial
		logger.info("{}: fetching product", this.getClass().getName());
		return null;
	}
}
