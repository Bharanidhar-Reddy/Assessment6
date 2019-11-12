package com.example.model;

import java.util.LinkedList;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "artists")
public class Artist {
	
	@Id
	private String id;
	
	private String name;
	
	@DBRef
	List<Album> albums= new LinkedList<Album>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Album a) {
		this.albums.add(a);
	}

	public Artist() {
	}
	
	
	
}
