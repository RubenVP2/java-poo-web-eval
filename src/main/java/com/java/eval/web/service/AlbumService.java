package com.java.eval.web.service;

import com.java.eval.web.exception.ConflictException;
import com.java.eval.web.model.Album;
import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;

@Service
@Validated
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    // Exercice 7
    public Album creerAlbum(Album alb) throws ConflictException {
        // Test si l'album existe déjà
        if( albumRepository.findByTitleIgnoreCase(alb.getTitle()).isPresent()) {
            throw new ConflictException("L'album de nom " + alb.getTitle() + " existe déjà !");
        }
        // Test si l'artiste est dans la bdd
        Artist a = alb.getArtist();
        if(a == null){
            throw new EntityNotFoundException("Impossible de trouver l'artiste avec l'id : " + a.getId());
        }
        alb.setArtist(a);
        return albumRepository.save(alb);
    }

    // Exercice 8
    public void deleteAlbum(Integer id) {
        if ( !albumRepository.existsById(id) ) {
            throw new EntityNotFoundException("L'album avec l'id : " + id + " n'existe pas !");
        }
        albumRepository.deleteById(id);
    }
}
