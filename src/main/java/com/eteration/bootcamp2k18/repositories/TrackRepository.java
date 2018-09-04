package com.eteration.bootcamp2k18.repositories;


import com.eteration.bootcamp2k18.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Long> {
    Track findByName(String name);
}
