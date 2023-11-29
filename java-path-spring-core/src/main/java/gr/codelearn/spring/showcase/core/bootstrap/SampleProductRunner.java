package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.domain.Product;
import gr.codelearn.spring.showcase.core.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@RequiredArgsConstructor
public class SampleProductRunner extends BaseComponent implements CommandLineRunner {
	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		productService.addAll(List.of(
				Product.builder().serial("S1").name("Sample product 1").price(BigDecimal.valueOf(10.25)).build(),
				Product.builder().serial("S2").name("Sample product 2").price(BigDecimal.valueOf(32.40)).build()));
	}
}
