package com.java.eval.web.repository;
import com.java.eval.web.model.Artist;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {

    // Exercice 1
    @Override
    Optional<Artist> findById(Integer integer);
}
