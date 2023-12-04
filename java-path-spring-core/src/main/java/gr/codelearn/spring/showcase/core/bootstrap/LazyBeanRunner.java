package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.component.LazyBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class LazyBeanRunner extends BaseComponent implements CommandLineRunner {
	private final LazyBean lazyBean;

	// Notice the @Lazy component that is also existent here during injection
	@Lazy
	public LazyBeanRunner(LazyBean lazyBean) {
		this.lazyBean = lazyBean;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Going to call a lazy bean to wake up.");
		lazyBean.sayHello();
	}
}
