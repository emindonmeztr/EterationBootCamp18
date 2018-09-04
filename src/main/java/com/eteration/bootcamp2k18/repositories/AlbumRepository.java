package com.eteration.bootcamp2k18.repositories;

import com.eteration.bootcamp2k18.model.Album;
import com.eteration.bootcamp2k18.type.FormatEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Long> {

    Album findByName(String name);

    Album findByYear(int year);

    List<Album> findByGenre(String genre);

    List<Album>  findByStyle(String style);

    List<Album> findByFormat(FormatEnum format);

    List<Album> findByCountry(String Country);


    Album findTopByOrderByNameDesc();

    @Query("select album from Album album where album.artist.name=:artistName")
    List<Album> findByArtistName(@Param("artistName") String name);
/*
    @Query("select album from Album album where :year < album.year between album.year < :year + 10")
    List<Album> findByDecade(@Param("year") int year);
*/




   // List<Album> findByDecadeOrderByYearDesc(int decade);

}

