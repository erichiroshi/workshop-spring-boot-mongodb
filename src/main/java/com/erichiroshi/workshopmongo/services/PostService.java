package com.erichiroshi.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erichiroshi.workshopmongo.domain.Post;
import com.erichiroshi.workshopmongo.repositories.PostRepository;
import com.erichiroshi.workshopmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(String id) {
		return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
	}

	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}

	public Post insert(Post post) {
		return repository.save(post);
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}

}
