package com.erichiroshi.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erichiroshi.workshopmongo.domain.User;
import com.erichiroshi.workshopmongo.domain.dto.UserDTO;
import com.erichiroshi.workshopmongo.repositories.UserRepository;
import com.erichiroshi.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public User insert(User user) {
		return repository.save(user);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repository.save(newUser);
	}

	private void updateData(User newUser, User user) {
		newUser.setName(user.getEmail());
		newUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
