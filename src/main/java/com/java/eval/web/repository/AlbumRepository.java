package com.java.eval.web.repository;
import com.java.eval.web.model.Album;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AlbumRepository extends PagingAndSortingRepository<Album, Integer> {

    // Exercice 7
    @Override
    <S extends Album> S save(S s);

    Optional<Album> findByTitleIgnoreCase(String title);

    // Exercice 8
    @Override
    void deleteById(Integer integer);
}
