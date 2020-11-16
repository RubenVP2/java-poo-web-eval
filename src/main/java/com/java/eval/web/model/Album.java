package com.java.eval.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "Album")
@JsonIgnoreProperties("artist")
public class Album {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    private Integer id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "ArtistId", nullable = false)
    private Artist artist;


}
