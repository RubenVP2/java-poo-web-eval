package com.java.eval.web.controller;

import com.java.eval.web.exception.ConflictException;
import com.java.eval.web.model.Album;
import com.java.eval.web.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    // Exercice 7
    @PostMapping(value= "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Album createAlbum(@RequestBody Album album) throws ConflictException {
        return albumService.creerAlbum(album);
    }

    // Exercice 8
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteAlbum(@PathVariable("id") Integer id ) { albumService.deleteAlbum(id); }
}
