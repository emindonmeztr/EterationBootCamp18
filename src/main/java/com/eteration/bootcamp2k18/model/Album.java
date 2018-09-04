package com.eteration.bootcamp2k18.model;

import com.eteration.bootcamp2k18.type.FormatEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ALBUM")
public class Album {

    @Id
    @GeneratedValue
    @Column(name="ALBUM_ID")
    private Long id;

    private String name;
    private int year;
    private FormatEnum format;
    private String country;
    private String photo;
    private String style;
    private double rate;
    private double price;
    private String label;
    private String genre;

    @OneToMany(mappedBy="album")
    private List<Track> trackList = new ArrayList<>();

    @JsonIgnoreProperties(value = "albumList")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="ARTIST_ID")
    private Artist artist;

    public Album() {

    }

    public Album(Long id, String name, int year, FormatEnum format, String country, String photo, String style, double rate, double price, String label, String genre, List<Track> trackList, Artist artist) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.format = format;
        this.country = country;
        this.photo = photo;
        this.style = style;
        this.rate = rate;
        this.price = price;
        this.label = label;
        this.genre = genre;
        this.trackList = trackList;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public FormatEnum getFormat() {
        return format;
    }

    public void setFormat(FormatEnum format) {
        this.format = format;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
