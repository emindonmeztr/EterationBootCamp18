package com.eteration.bootcamp2k18.controller;

import com.eteration.bootcamp2k18.model.Album;
import com.eteration.bootcamp2k18.model.Artist;
import com.eteration.bootcamp2k18.model.Consumer;
import com.eteration.bootcamp2k18.model.Track;
import com.eteration.bootcamp2k18.repositories.AlbumRepository;
import com.eteration.bootcamp2k18.repositories.ArtistRepository;
import com.eteration.bootcamp2k18.type.FormatEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistRepository artistRepository;

    @GetMapping("/all")
    public List<Album> getAll(){

        return albumRepository.findAll();
    }


    @GetMapping("id/{id}")
    public Album getAlbum(@PathVariable long id) {
        return albumRepository.findById(id).get();
    }

    @GetMapping("name/{name}")
    public Album getName(@PathVariable(value = "name") String name){
        return albumRepository.findByName(name);
    }

    @PostMapping
    public Album saveAlbum(@RequestBody Album album){

        List<Artist> byNameAndSurname = artistRepository.findByNameAndSurname(album.getArtist().getName(), album.getArtist().getSurname());

        if(!byNameAndSurname.isEmpty()){
            for(int i = 0; i < byNameAndSurname.size(); i++) {
                album.setArtist(byNameAndSurname.get(i));
            }
        }

        return albumRepository.save(album);
    }

    @DeleteMapping("id/{id}")
    public void deleteAlbumById(@PathVariable("id") Long id){

        albumRepository.delete(albumRepository.getOne(id));

    }

    @DeleteMapping("year/{year}")
    public void deleteAlbumByYear(@PathVariable("year") Integer year){

        albumRepository.delete(albumRepository.findByYear(year));

    }

    /*Old version*/
    @RequestMapping(path = "artist-name/{artistname}",method = RequestMethod.GET)
    public List<Album> getAlbumsByArtistName(@PathVariable("artistname") String artistname){

        return albumRepository.findByArtistName(artistname);

    }
/*
    @GetMapping("decade/{year}")
    public List<Album> getAlbumsByDecade(@PathVariable(value = "year") int year) {
        return albumRepository.findByDecadeOrderByYearDesc(year);
    }

*/
/*
    @RequestMapping(path ="decade/{year}" , method = RequestMethod.GET)
    public List<Album> getByDecade(@PathVariable("decade") Integer year){
        return albumRepository.findByDecade(year);
    }

*/
    @GetMapping("genre/{genre}")
    public List<Album> getGenre(@PathVariable(value = "genre") String genre) {
        return albumRepository.findByGenre(genre);
    }

    @GetMapping("style/{style}")
    public List<Album> getStyle(@PathVariable(value = "style") String style) {
        return albumRepository.findByStyle(style);
    }

    @GetMapping("format/{format}")
    public List<Album> getFormat(@PathVariable(value = "format") FormatEnum format) {
        return albumRepository.findByFormat(format);
    }

    @GetMapping("country/{country}")
    public List<Album> getCountry(@PathVariable(value = "country") String country) {
        return albumRepository.findByCountry(country);
    }

    @PutMapping("id/{id}")
    public void updateAlbum(@RequestBody Album album){
        albumRepository.save(album);
    }
}
