package com.java.eval.web.controller;
import com.java.eval.web.exception.ConflictException;
import com.java.eval.web.model.Artist;
import com.java.eval.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    // Exercice 1
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist findById(@PathVariable(value = "id") Integer id) {
        return artistService.findById(id);
    }

    // Exercice 2
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE, params = "name")
    public List<Artist> findByName(@RequestParam("name") String name) { return artistService.findByName(name); }

    // Exercice 3
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Artist> findAll(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size,
            @RequestParam(value = "sortProperty", defaultValue = "name") String sortProperty,
            @RequestParam(value = "sortDirection", defaultValue = "ASC") String sortDirection){
        return artistService.findAllArtists(page, size, sortProperty, sortDirection);
    }

    //Exercice 4
    @PostMapping(value= "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist createArtist(@RequestBody Artist artist) throws ConflictException {
        return artistService.creerArtist(artist);
    }

    // Exercice 5
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public Artist updateArtist(@PathVariable("id") Integer id, @RequestBody Artist artist){
        return this.artistService.updateArtist(id,artist);
    }
}
