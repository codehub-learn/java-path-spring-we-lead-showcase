package gr.codelearn.spring.showcase.core.repository;

import gr.codelearn.spring.showcase.core.domain.User;

import java.util.List;

public interface UserRepository {
	List<User> getUsers();

	User getUser(Long id);

	User getUser(String username);

	boolean save(User user);
}
