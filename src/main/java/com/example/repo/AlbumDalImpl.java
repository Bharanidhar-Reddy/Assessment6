package com.example.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Album;
import com.example.model.Track;

@Repository
public class AlbumDalImpl implements AlbumDal{
	
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Album create(Album b) {
		return mongo.save(b);
	}

	@Override
	public Album find(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Album.class).get(0);
	}

	@Override
	public List<Track> getAlbumTracks(String id) {
		return mongo.find(new Query(Criteria.where("id").is(id)), Album.class).get(0).getTracks();
	}

	@Override
	public Album addTrackToAlbum(Track a, Album b) {
		b.setTracks(a);
		return mongo.save(b);
	}
	
	@Override
	public boolean deleteAlbum(String id) {
		Album b=find(id);
		return mongo.remove(b).wasAcknowledged();
	}

}
