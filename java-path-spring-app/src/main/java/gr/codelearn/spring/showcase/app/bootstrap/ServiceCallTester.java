package gr.codelearn.spring.showcase.app.bootstrap;

import gr.codelearn.spring.showcase.app.base.BaseComponent;
import gr.codelearn.spring.showcase.app.service.OrderService;
import gr.codelearn.spring.showcase.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("service-call-tester")
@RequiredArgsConstructor
public class ServiceCallTester extends BaseComponent implements CommandLineRunner {
	private final OrderService orderService;
	private final ProductService productService;

	@Override
	public void run(final String... args) throws Exception {
		logger.debug("{}", productService.get(1L));
		logger.debug("{}", orderService.findWithAllAssociations(2L).get());
	}
}
