package gr.codelearn.spring.showcase.core.component;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Conditional(DatabaseCondition.class)
@Component
public class DataSource extends BaseComponent {
	// Class and code that maintains a connection pooling

	@Value("${spring.datasource.driver-class-name}")
	private String driveClassName;

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String dbUsername;

	@Value("${spring.datasource.password}")
	private String dbPassword;

	public static Connection getConnection() {
		// Code that fetches an available connection from the pool
		return null;
	}

	public void createConnectionPool() {
		// Code that creates a connection pool
		logger.info("Datasource reports: Database driver full class name: {}, url: {}, username: {}, password: {}",
					driveClassName, dbUrl, dbUsername, dbPassword);
	}

}
