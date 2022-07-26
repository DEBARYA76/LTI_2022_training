package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.lti.entity.Album;
import com.lti.entity.Insurance;
import com.lti.entity.Song;

public class AlbumSongDaoImpl implements AlbumSongDao {

	EntityManagerFactory emf;
	EntityManager em;
	EntityTransaction tx;
	
	
	
	
	public AlbumSongDaoImpl() {
		
		emf = Persistence.createEntityManagerFactory("oracle-pu");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public Album addOrUpdate(Album album) {
		tx.begin();
	    Album albumPersisted = em.merge(album);
		tx.commit();
		return albumPersisted;
	}

	public Album searchAlbumById(int albumId) {
		// TODO Auto-generated method stub
		return em.find(Album.class, albumId);
	}

	public List<Album> viewAllAlbums() {
//		String jpql = "select alb from Album alb ";
//		TypedQuery<Album> query = em.createQuery(jpql ,Album.class);
//		List<Album> albums=query.getResultList();
//		return albums;
	
		return em.createQuery("select alb from Album alb",Album.class).getResultList();
	}

	public Song addOrUpdate(Song song) {
		tx.begin();
	   Song songPersisted = em.merge(song);
		tx.commit();
		return songPersisted;
	}

	public Song searchSongById(int songId) {
		return em.find(Song.class, songId);
	}
public void  removeSongById(int songId)
{
	Song song=searchSongById(songId);
	tx.begin();
	em.remove(song);
	tx.commit();
	System.out.println("song remove");
	

}
	public List<Song> viewAllSongs() {
		return em.createQuery("select sng from Song sng", Song.class)
				.getResultList();
	}

	public List<Song> searchSongByArtistName(String artist) {
         String jpql="select p from Song p where p.artist=:artistName";
         TypedQuery<Song> qry=em.createQuery(jpql,Song.class);
         qry.setParameter("artistName",artist);
         List<Song> p = qry.getResultList();
         return p;
 }
	public Album getAlbumWithMostSongs(){
        String jpql = "select alb from Album alb order by noOfSongs";
        TypedQuery<Album> query = em.createQuery(jpql, Album.class);
        query.setMaxResults(1);

        return query.getSingleResult();
    }
	
	
	
	
	
	
}



