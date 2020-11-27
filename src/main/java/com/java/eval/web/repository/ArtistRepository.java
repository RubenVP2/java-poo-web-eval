package com.java.eval.web.repository;

import com.java.eval.web.model.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends PagingAndSortingRepository<Artist, Integer> {

    // Exercice 1
    @Override
    Optional<Artist> findById(Integer integer);

    // Exercice 2
    List<Artist> findByNameIgnoreCaseContaining(String name);

    // Exercice 3
    @Override
    Page<Artist> findAll(Pageable pageable);

    // Exercice 4
    @Override
    <S extends Artist> S save(S s);

    Optional<Artist> findByNameIgnoreCase(String name);

    // Exercice 5
    @Override
    boolean existsById(Integer integer);

    // Exercice 6
    @Override
    void deleteById(Integer integer);
}
