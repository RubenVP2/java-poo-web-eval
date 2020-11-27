package com.java.eval.web.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Artist")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ArtistId")
    private Integer id;

    @NonNull
    private String name;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("artist")
    private Set<Album> albums = new HashSet();
}
