package com.erichiroshi.workshopmongo.config;

import java.io.Serializable;

import com.erichiroshi.workshopmongo.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AuthorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public AuthorDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
	}

}
