package gr.codelearn.spring.showcase.app.controller;

import gr.codelearn.spring.showcase.app.mapper.BaseMapper;
import gr.codelearn.spring.showcase.app.mapper.ProductMapper;
import gr.codelearn.spring.showcase.app.model.Product;
import gr.codelearn.spring.showcase.app.service.BaseService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import gr.codelearn.spring.showcase.app.transfer.resource.ProductResource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController extends BaseController<Product, ProductResource> {
	private final ProductService productService;
	private final ProductMapper productMapper;

	@Override
	protected BaseService<Product, Long> getBaseService() {
		return productService;
	}

	@Override
	protected BaseMapper<Product, ProductResource> getMapper() {
		return productMapper;
	}
}
