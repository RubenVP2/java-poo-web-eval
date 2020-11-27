package com.java.eval.web;

import com.java.eval.web.repository.AlbumRepository;
import com.java.eval.web.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public void run(String... strings) throws Exception {

        System.out.println("Nombre d'artiste " + artistRepository.count());

        System.out.println("Nombre d'album " + albumRepository.count());

    }
}
