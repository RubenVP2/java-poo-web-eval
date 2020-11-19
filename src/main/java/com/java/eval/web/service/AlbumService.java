package com.java.eval.web.service;

import com.java.eval.web.model.Album;
import com.java.eval.web.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;


}
