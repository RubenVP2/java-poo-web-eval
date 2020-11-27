package com.java.eval.web.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Album")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Album {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "AlbumId")
    private Integer id;

    @NonNull
    private String title;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "ArtistId")
    private Artist artist;

}
