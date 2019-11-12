package com.example.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Album;
import com.example.model.Artist;



@Repository
public class ArtistDalImpl implements ArtistDal{
	
	@Autowired
	private MongoTemplate mongo;
	
	
	@Override
	public Artist create(Artist a) {
		return mongo.save(a);
	}

	@Override
	public Artist find(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Artist.class).get(0);
	}

	@Override
	public List<Artist> findall() {
		// TODO Auto-generated method stub
		return mongo.findAll(Artist.class);
	}

	@Override
	public List<Album> getArtistAlbums(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Artist.class).get(0).getAlbums();
	}

	@Override
	public Artist addAlbumToArtist(Album a, Artist b) {
		b.setAlbums(a);
		return mongo.save(b);
	}

	@Override
	public boolean deleteArtist(String id) {
		Artist a=find(id);
		return mongo.remove(a).wasAcknowledged();
	}
	
}
