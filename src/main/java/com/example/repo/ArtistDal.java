package com.example.repo;

import java.util.List;

import com.example.model.Album;
import com.example.model.Artist;


public interface ArtistDal {
	public Artist create(Artist b);
	public Artist find(String id);
	public List<Artist> findall();
	public List<Album> getArtistAlbums(String id);
	public Artist addAlbumToArtist(Album a,Artist b);
	public boolean deleteArtist(String id);
}
