package com.eteration.bootcamp2k18.type;

public enum FormatEnum {

    CD("cd"),AAC("aac"),VINYL("vinyl");

    String description;

    FormatEnum(String description){
        this.description = description;
    }


    public String getDescription(){
        return this.description;
    }
}
