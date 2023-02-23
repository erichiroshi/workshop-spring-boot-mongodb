package com.erichiroshi.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erichiroshi.workshopmongo.domain.Post;
import com.erichiroshi.workshopmongo.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> findAll() {
		List<Post> listDTO = service.findAll();
		return ResponseEntity.ok().body(listDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);
	}

}
