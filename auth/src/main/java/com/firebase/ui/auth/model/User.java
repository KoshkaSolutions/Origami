package com.firebase.ui.auth.model;

import java.util.List;

/**
 * Created by imuntean on 7/20/16.
 */
public class User {

    private String uid;
    private String email;
    private String username;
    private String displayName;
    private String country;
    private List<Friend> friendList;
    private Coordinate currentLocation;
    private List<Origami> origamiList;

    public User() {
    }

    public User(String email) {
        this.email = email;
    }

    public User(String email, String uid) {
        this.email = email;
        this.uid = uid;
    }

    public User(String displayName, String uid, String email) {
        this.displayName = displayName;
        this.uid = uid;
        this.email = email;
    }

    public User(String uid, String email, String username, String country, String displayName) {
        this.uid = uid;
        this.email = email;
        this.username = username;
        this.country = country;
        this.displayName = displayName;
    }

    public List<Friend> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Friend> friendList) {
        this.friendList = friendList;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Coordinate getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Coordinate currentLocation) {
        this.currentLocation = currentLocation;
    }

    public List<Origami> getOrigamiList() {
        return origamiList;
    }

    public void setOrigamiList(List<Origami> origamiList) {
        this.origamiList = origamiList;
    }
}
