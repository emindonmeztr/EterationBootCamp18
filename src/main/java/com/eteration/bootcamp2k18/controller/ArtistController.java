package com.eteration.bootcamp2k18.controller;

import com.eteration.bootcamp2k18.model.Artist;
import com.eteration.bootcamp2k18.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    ArtistRepository artistRepository;

    @GetMapping("/all")
    public List<Artist> getAllArtists(){
        return artistRepository.findAll();
    }


    @GetMapping("id/{id}")
    public Artist getArtist(@PathVariable long id) {
        return artistRepository.findById(id).get();
    }


    @GetMapping("name/{name}")
    public List<Artist> getName(@PathVariable(value = "name") String name){
        return artistRepository.findByName(name);
    }

    @GetMapping("surname/{surname}")
    public List<Artist> getSurname(@PathVariable(value = "surname") String surname){
        return artistRepository.findBySurname(surname);
    }

    @GetMapping("name-and-surname/{name}/{surname}")
    public List<Artist> getNameAndSurname(@PathVariable(value ="name") String name, @PathVariable(value="surname") String surname){
        return artistRepository.findByNameAndSurname(name,surname);
    }

    @PostMapping
    public void createArtist(@RequestBody Artist artist){

        artistRepository.save(artist);
    }

   /*
    @PostMapping
    public Artist saveArtist(@RequestBody Artist artist) {

        return artistRepository.save(artist);

    }
*/

    @DeleteMapping("id/{id}")
    public void deleteArtistById(@PathVariable("id") Long id){

        artistRepository.delete(artistRepository.getOne(id));

    }

    @PutMapping("id/{id}")
    public void updateArtist(@RequestBody Artist artist){
        artistRepository.save(artist);
    }
}
