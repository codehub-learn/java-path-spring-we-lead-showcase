package gr.codelearn.spring.showcase.core.bootstrap;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleRunner extends BaseComponent implements CommandLineRunner {
	private final Environment env;
	private final ApplicationContext applicationContext;

	@Override
	public void run(final String... args) throws Exception {
		logger.info("Hello from SimpleRunner.");
		logger.debug("Showing value of {}: {}", "spring.application.name", env.getProperty(
				"spring.application.name"));
	}
}
