package com.java.eval.web.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Album")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
