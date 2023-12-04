package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.component.Prototype;
import gr.codelearn.spring.showcase.core.component.Singleton;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(0)
@RequiredArgsConstructor
public class ScopeRunner extends BaseComponent implements CommandLineRunner {
	private final AnnotationConfigApplicationContext context;

	@Override
	public void run(String... args) throws Exception {
		// No matter how many times we fetch the bean, it is ALWAYS the same instance as its scope (by default) is
		// considered as singleton
		logger.info("Fetching Singleton bean...");
		Singleton singleton1 = context.getBean(Singleton.class);
		singleton1.increaseValueByOne();
		Singleton singleton2 = context.getBean(Singleton.class);
		singleton2.increaseValueByOne();
		Singleton singleton3 = context.getBean(Singleton.class);
		singleton3.increaseValueByOne();

		// Fetching a prototype bean, always creates a new instance, as defined by the its scope
		logger.info("Fetching Prototype bean...");
		Prototype prototype1 = context.getBean(Prototype.class);
		prototype1.increaseValueByOne();
		Prototype prototype2 = context.getBean(Prototype.class);
		prototype2.increaseValueByOne();
		Prototype prototype3 = context.getBean(Prototype.class);
		prototype3.increaseValueByOne();

		context.close();
	}
}
