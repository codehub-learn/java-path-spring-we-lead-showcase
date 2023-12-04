package gr.codelearn.spring.showcase.core.service;

import gr.codelearn.spring.showcase.core.domain.User;
import gr.codelearn.spring.showcase.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	private final UserRepository userRepository;

	@Override
	public boolean register(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public User getUser(Long id) {
		return userRepository.getUser(id);
	}

	@Override
	public User getUser(String username) {
		return userRepository.getUser(username);
	}
}
