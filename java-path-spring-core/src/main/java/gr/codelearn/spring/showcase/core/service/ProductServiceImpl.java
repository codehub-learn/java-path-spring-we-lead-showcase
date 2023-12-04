package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	@Override
	public List<Product> getProducts() {
		return productRepository.getProducts();
	}

	@Override
	public Product getProduct(String serial) {
		return productRepository.getProduct(serial);
	}
}
