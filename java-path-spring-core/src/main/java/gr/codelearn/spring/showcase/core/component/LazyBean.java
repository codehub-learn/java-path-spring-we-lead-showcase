package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class LazyBean extends BaseComponent {
	public void sayHello() {
		logger.info("Hello, guess I am lazy.");
	}
}
