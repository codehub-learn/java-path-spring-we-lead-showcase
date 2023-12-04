package gr.codelearn.spring.showcase.core.repository.sql;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.repository.DataRepository;
import gr.codelearn.spring.showcase.core.repository.ProductRepository;
import gr.codelearn.spring.showcase.core.repository.pooling.ProductRepositoryImplSQLWithConnectionPooling;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Qualifier("sql")
@ConditionalOnMissingBean(ProductRepositoryImplSQLWithConnectionPooling.class)
public class ProductRepositoryImplSql extends BaseComponent implements ProductRepository, DataRepository {
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
