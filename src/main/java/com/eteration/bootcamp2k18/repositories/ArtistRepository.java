package com.eteration.bootcamp2k18.repositories;


import com.eteration.bootcamp2k18.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    List<Artist> findByName(String name);
    List<Artist> findByNameAndSurname(String name, String surname);
    List<Artist> findBySurname(String surname);

}

