package com.erichiroshi.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.erichiroshi.workshopmongo.dto.AuthorDTO;
import com.erichiroshi.workshopmongo.dto.CommentDTO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Document(collection = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO author;

	private List<CommentDTO> comments = new ArrayList<>();

	public Post(String id, Date date, String title, String body, AuthorDTO author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}

}
