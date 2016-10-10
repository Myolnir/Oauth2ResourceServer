package com.myolnir.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDto {

    private String name;
    private String id;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
