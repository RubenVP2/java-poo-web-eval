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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album() {}

    public Album(Integer id, String title, Artist artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }
}
