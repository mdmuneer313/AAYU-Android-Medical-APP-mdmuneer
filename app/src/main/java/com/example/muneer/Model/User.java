package com.example.muneer.Model;

public class User {

    private String id;
    private String username;
    private String imageURL;
    private String fullname;
    private String email;
    private String phone;
    private String search;

    public User(String id, String username, String imageURL, String fullname, String email,String phone,String search) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.search = search;
    }

    public User() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}