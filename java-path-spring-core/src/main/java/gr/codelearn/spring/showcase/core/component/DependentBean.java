package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("independentBean")
public class DependentBean extends BaseComponent {
	@PostConstruct
	public void sayHello() {
		// Code that will be executed after the initialization of the bean
		logger.info("Hello, I am a dependent bean.");
	}

	@PreDestroy
	public void sayBye() {
		// Code that will be executed before the bean is destroyed
		logger.info("Bye bye, I used to be a dependent bean.");
	}
}
