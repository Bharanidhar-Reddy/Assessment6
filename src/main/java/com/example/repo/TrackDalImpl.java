package com.example.repo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


import com.example.model.Track;

@Repository
public class TrackDalImpl implements TrackDal{
	
	@Autowired
	private MongoTemplate mongo;
	
	@Override
	public Track create(Track b) {
		return mongo.save(b);
	}
	@Override
	public boolean deleteTrack(String id) {
		Track t=mongo.find(new Query(Criteria.where("id").is(id)), Track.class).get(0);
		return mongo.remove(t).wasAcknowledged();
	}
}
