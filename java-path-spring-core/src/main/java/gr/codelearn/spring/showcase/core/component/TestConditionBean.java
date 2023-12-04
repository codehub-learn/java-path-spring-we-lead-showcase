package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component
@Conditional({DatabaseCondition.class})
public class TestConditionBean extends BaseComponent {
	@PostConstruct
	public void createStorageDirectories() {
		logger.info("Simulating creating a temporary folder.");
	}

	@PreDestroy
	public void deleteStorageDirectories() {
		logger.info("Simulating deleting temporary folder.");
	}
}
