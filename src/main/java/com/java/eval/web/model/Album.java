package com.java.eval.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @OneToOne
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;


}
