package app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.User;
import app.dto.UserDTO;
import app.repository.UserRepository;
import app.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	public User created(User user) {
		return repo.insert(user);
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("object not found"));
	}

	public User updated(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repo.save(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setName(user.getName());
		newUser.setEmail(user.getEmail());
	}

	public void delete(String id) {
		this.findById(id);
		repo.deleteById(id);
	}

	public User fromDTO(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
}
