package com.java.eval.web.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "artist")
    private Set<Album> albums = new HashSet();

}
