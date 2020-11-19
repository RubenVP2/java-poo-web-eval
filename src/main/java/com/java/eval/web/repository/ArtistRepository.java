package com.java.eval.web.repository;
import com.java.eval.web.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {

    // Exercice 1
    @Override
    Optional<Artist> findById(Integer integer);

    // Exercice 2
    List<Artist> findByNameIgnoreCaseContaining(String name);

    // Exercice 3
    @Override
    Page<Artist> findAll(Pageable pageable);
}
