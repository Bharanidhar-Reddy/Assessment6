package com.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Album;
import com.example.model.Artist;
import com.example.model.Track;
import com.example.repo.AlbumDal;
import com.example.repo.ArtistDal;
import com.example.repo.TrackDal;


@RestController
public class Controller {
	
	@Autowired
	private AlbumDal albumdal;
	
	@Autowired
	private ArtistDal artistdal;
	
	@Autowired
	private TrackDal trackdal;
	
	@GetMapping("/artists")
	private List<Artist> findall(){
		return artistdal.findall();
	}
	
	@GetMapping(value = "/artists/{id}/albums")
	private List<Album> findalbums(@PathVariable("id") String id){
		return artistdal.getArtistAlbums(id);
	}
	
	@GetMapping(value = "/artists/{id}/albums/{aid}/tracks")
	private List<Track> findtracks(@PathVariable("id") String id,@PathVariable("aid") String id2){
		return albumdal.getAlbumTracks(id2);
	}
	
	@PostMapping(value="/artists")
	private Artist addartist(@RequestBody Artist a) {
		return artistdal.create(a);
	}
	
	@PostMapping(value = "/artists/{id}/albums")
	private Album addalbums(@PathVariable("id") String id,@RequestBody Album a){
		albumdal.create(a);
		artistdal.addAlbumToArtist(a, artistdal.find(id));
		return a;
	}
	@PostMapping(value = "/artists/{id}/albums/{aid}")
	private Track addtrack(@PathVariable("id") String id,@PathVariable("aid") String id2,@RequestBody Track t){
		trackdal.create(t);
		albumdal.addTrackToAlbum(t, albumdal.find(id2));
		return t;
	}
	@DeleteMapping(value = "/artists/{id}")
	private boolean deleteartist(@PathVariable("id") String id){
		return artistdal.deleteArtist(id);
	}
	@DeleteMapping(value = "/albums/{id}")
	private boolean deletealbum(@PathVariable("id") String id){
		return albumdal.deleteAlbum(id);
	}
	
	@DeleteMapping(value = "/tracks/{id}")
	private boolean deletetrack(@PathVariable("id") String id){
		return trackdal.deleteTrack(id);
	}
}
