package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_album")
public class Album {

	@Id
	@SequenceGenerator(name = "album_seq", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "album_seq", strategy = GenerationType.SEQUENCE)
	int albumId;

	String albumName;
	int noOfSongs;
	LocalDate releaseDate;
	String label;

//	@OneToMany(mappedBy = "album")
//	List<Song> songs;
	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
	List<Song> songs;

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public int getNoOfSongs() {
		return noOfSongs;
	}

	public void setNoOfSongs(int noOfSongs) {
		this.noOfSongs = noOfSongs;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate date) {
		this.releaseDate = date;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

}
