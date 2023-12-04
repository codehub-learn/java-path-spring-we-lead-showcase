package gr.codelearn.spring.showcase.core.component;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseCondition implements Condition {
	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
		// Condition checks whether database is up or not
		return true;
	}
}
