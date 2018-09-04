package com.eteration.bootcamp2k18.model;

import javax.persistence.*;

@Entity
@Table(name="TRACK")
public class Track {

    @Id
    @GeneratedValue
    @Column(name="TRACK_ID")
    private Long id;

    private String name;
    private double duration;
    private String note;
    private String lyrics;
    private double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @ManyToOne
    @JoinColumn(name="ALBUM_ID")
    private Album album;

    @ManyToOne
    @JoinColumn(name="ARTIST_ID")
    private Artist artist;

    public Track(Long id, String name, Double duration, String note, String lyrics, Double price, Album album, Artist artist) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.note = note;
        this.lyrics = lyrics;
        this.price = price;
        this.album = album;
        this.artist = artist;
    }

    public Track(){

    }

}
