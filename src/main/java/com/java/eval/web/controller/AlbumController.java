package com.java.eval.web.controller;
import com.java.eval.web.exception.ConflictException;
import com.java.eval.web.model.Album;
import com.java.eval.web.model.Artist;
import com.java.eval.web.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping(value= "", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Album createAlbum(@RequestBody Album album) throws ConflictException {
        return albumService.creerAlbum(album);
    }
}
