package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class IndependentBean extends BaseComponent {
	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am an independent bean.");
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be an independent bean.");
	}
}
