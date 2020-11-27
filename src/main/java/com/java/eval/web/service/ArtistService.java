package com.java.eval.web.service;

import com.java.eval.web.exception.ConflictException;
import com.java.eval.web.model.Artist;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
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

    // Exerice 2
    public List<Artist> findByName(String name) {
        return artistRepository.findByNameIgnoreCaseContaining(name);
    }

    // Exercice 3
    public Page<Artist> findAllArtists(
            Integer page,
            Integer size,
            String sortProperty,
            String sortDirection
    ) {
        //Vérification de sortProperty
        if(Arrays.stream(Artist.class.getDeclaredFields()).
                map(Field::getName).
                filter(s -> s.equals(sortProperty)).count() != 1){
            throw new IllegalArgumentException("La propriété " + sortProperty + " n'existe pas !");
        }

        if ( !"ASC".equalsIgnoreCase(sortDirection) && !"DESC".equalsIgnoreCase(sortDirection)) {
            throw new IllegalArgumentException("Le sens de tri doit valoir ASC ou DESC");
        }
        Pageable pageable = PageRequest.of(page,size,Sort.Direction.fromString(sortDirection), sortProperty);
        Page<Artist> artists = artistRepository.findAll(pageable);
        // Gestion des erreurs
        if(page >= artists.getTotalPages()){
            throw new IllegalArgumentException("Le numéro de page ne peut être supérieur à " + artists.getTotalPages());
        } else if(artists.getTotalElements() == 0){
            throw new EntityNotFoundException("Il n'y a aucun artistes dans la base de données");
        }
        return artists;
    }

    // Exercice 4
    public Artist creerArtist(Artist a) throws ConflictException {
        if( artistRepository.findByNameIgnoreCase(a.getName()).isPresent()) {
            throw new ConflictException("L'artiste de nom " + a.getName() + " existe déjà !");
        }
        return artistRepository.save(a);
    }

    // Exercice 5
    public <T extends Artist> T updateArtist(Integer id, @Valid T artist) {
        if(!artistRepository.existsById(id)) {
            throw new EntityNotFoundException("L'artiste d'identifiant " + id + " n'existe pas !");
        }
        if(!id.equals(artist.getId())) {
            throw new IllegalArgumentException("Requête invalide");
        }
        return artistRepository.save(artist);
    }

    // Exercice 6
    public void deleteArtist(Integer id) {
        artistRepository.deleteById(id);
    }
}
