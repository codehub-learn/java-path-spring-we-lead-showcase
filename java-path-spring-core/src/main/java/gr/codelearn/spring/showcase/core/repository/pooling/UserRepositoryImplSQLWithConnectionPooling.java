package gr.codelearn.spring.showcase.core.repository.pooling;

import gr.codelearn.spring.showcase.core.base.BaseComponent;
import gr.codelearn.spring.showcase.core.domain.User;
import gr.codelearn.spring.showcase.core.repository.DataRepository;
import gr.codelearn.spring.showcase.core.repository.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
@Primary
@ConditionalOnClass(name = "gr.codelearn.spring.showcase.core.undefined.DataSource")
public class UserRepositoryImplSQLWithConnectionPooling extends BaseComponent
		implements UserRepository, DataRepository {

	@Override
	public void logData(String command) {
		// Code for logging data
		logger.info("{}: logging data", this.getClass().getName());
	}

	@Override
	public boolean save(User user) {
		// Code for saving
		logger.info("{}: saving user", this.getClass().getName());
		return true;
	}

	@Override
	public List<User> getUsers() {
		// Code for getting all users
		logger.info("{}: fetching all users", this.getClass().getName());
		return Collections.emptyList();
	}

	@Override
	public User getUser(Long id) {
		// Code for getting a user by id
		logger.info("{}: fetching user by id", this.getClass().getName());
		return null;
	}

	@Override
	public User getUser(String username) {
		// Code for getting a user by username
		logger.info("{}: fetching user by username", this.getClass().getName());
		return null;
	}
}
