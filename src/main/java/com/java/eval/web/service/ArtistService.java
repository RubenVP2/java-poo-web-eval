package com.java.eval.web.service;

import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@Validated
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    // Exercice 1
    public Artist findById(Integer id) {
        Optional<Artist> artist = artistRepository.findById(id);
        if( !artist.isPresent() ) throw new EntityNotFoundException("L'artiste d'identifiant " + id + " n'a pas été trouvé.");
        return artist.get();
    }

}
