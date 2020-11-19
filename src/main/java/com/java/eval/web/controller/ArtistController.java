package com.java.eval.web.controller;
import com.java.eval.web.model.Artist;
import com.java.eval.web.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/artists")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Artist findById(@PathVariable(value = "id") Integer id) {
        return artistService.findById(id);
    }

}
