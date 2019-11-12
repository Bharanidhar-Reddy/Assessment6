package com.example.repo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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
}
