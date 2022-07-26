package com.lti.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.AlbumSongDao;
import com.lti.dao.AlbumSongDaoImpl;
import com.lti.entity.Album;
import com.lti.entity.Song;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;

public class AlbumSongTest {

	AlbumSongDao dao = new AlbumSongDaoImpl();

	@Test
	public void addOrUpdateAlbumTest() {
		Album album = new Album();
		album.setAlbumName("KK songs");
		album.setLabel("V-Series");
		album.setReleaseDate(LocalDate.of(1000, 11, 2));
		album.setNoOfSongs(30);

		Album savedAlbum = dao.addOrUpdate(album);
		assertNotNull(album);
	}

	@Test
	public void searchAlbumsByIdTest() {
		assertNotNull(dao.searchAlbumById(102));
	}

	@Test
	public void viewAllAlbumsTest() {
		List<Album> albums = dao.viewAllAlbums();
		assertNotEquals(0, albums.size());
	}

	@Test
	public void addOrUpdateASongTest() {
		Album album = dao.searchAlbumById(104);
		assertNotNull(album);

		Song song = new Song();
		song.setArtist("Lata");
		song.setLength(56);
		song.setSongTitle("TERE mere");
		song.setAlbum(album);

		Song savedSong = dao.addOrUpdate(song);

		assertNotNull(savedSong);
	}

	@Test
	public void searchSongByIdTest() {
		Song song = dao.searchSongById(501);

		assertNotNull(song);
	}

	@Test
	public void viewAllSongsTest() {
		List<Song> songs = dao.viewAllSongs();
		assertNotEquals(0, songs.size());
	}

	@Test
	public void addAlbumWithSongs() {
		Album album = new Album();
		album.setAlbumName("jug");
		album.setLabel("shem");
		album.setNoOfSongs(6);
		album.setReleaseDate(LocalDate.of(2011, 8, 2));

		List<Song> songs = new ArrayList();

		Song song1 = new Song();
		song1.setArtist("artist5");
		song1.setLength(2.98);
		song1.setSongTitle("title7");
		song1.setAlbum(album);
		Song song2 = new Song();
		song2.setArtist("artist2");
		song2.setLength(2.18);
		song2.setSongTitle("title6");
		song2.setAlbum(album);

		Song song3 = new Song();
		song3.setArtist("artist9");
		song3.setLength(3.12);
		song3.setSongTitle("title5");
		song3.setAlbum(album);

		songs.add(song3);
		songs.add(song2);
		songs.add(song1);

		album.setSongs(songs);

		dao.addOrUpdate(album);
	}

	@Test
	public void findAlbumBySongId() {
		Song song = dao.searchSongById(502);
		Album album = song.getAlbum();
		System.out.println(album.getAlbumId() + " " + album.getAlbumName());

	}

	@Test
	public void removeSong() {
		dao.removeSongById(504);
	}

	@Test
	public void fetchAllSongsToWhichSongsBelong() {

		Song song = dao.searchSongById(508);
		Album album = song.getAlbum();
		List<Song> songs = album.getSongs();
		songs.stream().forEach(s -> {
			System.out.println(s.getSongTitle() + " " + s.getAlbum());
		});
	}

	@Test
	public void updateSongDuration() {
//		int rec=dao.updateSongDuration(507,12);
//		assertNotEquals(0,rec);
		Song song = dao.searchSongById(507);
		song.setLength(5);
		dao.addOrUpdate(song);

	}

	@Test
	public void getTheLongestSong() {
		double max = Double.MIN_VALUE;
		int songid = 0;
		List<Song> songs = dao.viewAllSongs();
		for (Song song : songs) {
			if (song.getLength() > max) {
				max = song.getLength();
				songid = song.getSongId();

			}
		}
		Song song = dao.searchSongById(songid);
		System.out.println(song.getSongId() + " " + song.getSongTitle());
	}

	@Test
	public void getAllSongsByArtistName() {
		List<Song> songs = dao. searchSongByArtistName("Amitabh");
		for (Song song : songs) {
			System.out.println(song.getSongTitle());
		}
	}

	@Test
	public void getAllSongsByAlbumIds() {

		Album a = dao.searchAlbumById(100);
		List<Song> songs = a.getSongs();

		songs.stream().forEach(s -> {
			System.out.println(s.getSongId() + " " + s.getSongTitle());
		});
	}
	
	@Test
    public void getAlbumwithHighestNoOfSongs() {
        List<Album> albums = dao.viewAllAlbums();
        int max =Integer.MIN_VALUE;
        int albumId=0;
        for(Album album:albums)
        {
            if(album.getNoOfSongs()>max)
            {
                max=album.getNoOfSongs();
                albumId=album.getAlbumId();

            }
        }
        System.out.println(albumId);
    }
}
