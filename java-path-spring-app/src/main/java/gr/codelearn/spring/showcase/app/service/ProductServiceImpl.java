package gr.codelearn.spring.showcase.app.service;

import gr.codelearn.spring.showcase.app.model.Category;
import gr.codelearn.spring.showcase.app.model.Product;
import gr.codelearn.spring.showcase.app.repository.BaseRepository;
import gr.codelearn.spring.showcase.app.repository.CategoryRepository;
import gr.codelearn.spring.showcase.app.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	private final ProductRepository productRepository;
	private final CategoryService categoryService;

	@Override
	protected BaseRepository<Product, Long> getRepository() {
		return productRepository;
	}

	@Override
	public Product findBySerial(final String serial) {
		return productRepository.findBySerial(serial);
	}

	@Override
	public Product create(final Product product, final Long categoryId) {
		var category = categoryService.get(categoryId);
		product.setCategory(category);
		return productRepository.create(product);
	}
}
