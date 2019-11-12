package com.example.model;

import java.util.LinkedList;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "albums")
public class Album {
	@Id
	private String id;

	
	public Album() {
	}

	private String name;
	
	@DBRef
	private List<Track> tracks =new LinkedList<Track>();


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(Track t) {
		this.tracks.add(t);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
