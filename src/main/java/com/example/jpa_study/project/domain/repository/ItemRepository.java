package com.example.jpa_study.project.domain.repository;

import com.example.jpa_study.project.domain.Album;
import com.example.jpa_study.project.domain.Book;
import com.example.jpa_study.project.domain.Item;
import com.example.jpa_study.project.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {
    boolean existsByName(String name);
    @Query("select b from Book b where b.name =:name")
    Optional<Book> findBookByName(@Param("name") String bookName);
    @Query("select a from Album a where a.name =:name")
    Optional<Album> findAlbumByName(@Param("name") String albumName);
    @Query("select m from Movie m where m.name =:name")
    Optional<Movie> findMovieByName(@Param("name") String movieName);
}