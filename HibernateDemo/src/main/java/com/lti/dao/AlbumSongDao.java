package com.lti.dao;

import java.util.List;

import com.lti.entity.Album;
import com.lti.entity.Song;

public interface AlbumSongDao {

	
	
	Album addOrUpdate(Album album);
	Album searchAlbumById(int albumId);
	List<Album> viewAllAlbums();
	
	
	Song addOrUpdate(Song song);
	Song searchSongById(int songId);
	List<Song> viewAllSongs();
	void removeSongById(int songId);
	 List<Song> searchSongByArtistName(String artist);
}
