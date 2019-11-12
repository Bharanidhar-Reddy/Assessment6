package com.example.repo;




import com.example.model.Track;

public interface TrackDal {
	public Track create(Track b);

	boolean deleteTrack(String id);
}
