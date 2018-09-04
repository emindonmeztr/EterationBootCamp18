package com.eteration.bootcamp2k18.controller;


import com.eteration.bootcamp2k18.model.Track;
import com.eteration.bootcamp2k18.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/track")
public class TrackController {

    @Autowired
    TrackRepository trackRepository;

    @GetMapping("/all")
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }


    @GetMapping("id/{id}")
    public Track getTrack(@PathVariable long id) {
        return trackRepository.findById(id).get();
    }

    @GetMapping("name/{name}")
    public Track getName(@PathVariable(value = "name") String name){
        return trackRepository.findByName(name);
    }

    @PostMapping
    public void createTrack(@RequestBody Track track){

        trackRepository.save(track);
    }

    @DeleteMapping("id/{id}")
    public void deleteTrackById(@PathVariable("id") Long id){

        trackRepository.delete(trackRepository.getOne(id));

    }


    @PutMapping("id/{id}")
    public void updateTrack(@RequestBody Track track){
        trackRepository.save(track);
    }

}

