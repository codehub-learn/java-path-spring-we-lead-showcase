package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
@RequiredArgsConstructor
public class ProductRetrieverRunner extends BaseComponent implements CommandLineRunner {
	// Class that shows bean-related info etc.

	private final ProductService productService;

	@Override
	public void run(String... args) throws Exception {
		productService.getProducts();
	}
}
