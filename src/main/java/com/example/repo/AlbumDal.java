package com.example.repo;

import java.util.List;

import com.example.model.Track;
import com.example.model.Album;

public interface AlbumDal {
	public Album create(Album b);
	public Album find(String id);
	public List<Track> getAlbumTracks(String id);
	public Album addTrackToAlbum(Track a,Album b);
}
