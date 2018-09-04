package com.eteration.bootcamp2k18.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ARTIST")
public class Artist {

    @Id
    @GeneratedValue
    @Column(name="ARTIST_ID")
    private Long id;

    private String name;
    private String surname;

    private String photo;
    private String sites;
    private String bio;

    public Artist(Long id, String name, String surname, String photo, String sites, String bio, List<Album> albumList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.photo = photo;
        this.sites = sites;
        this.bio = bio;
        this.albumList = albumList;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @OneToMany(mappedBy="artist", cascade=CascadeType.ALL)
    private List<Album> albumList = new ArrayList<>();

    public Artist(){

    }

}
