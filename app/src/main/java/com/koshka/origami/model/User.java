package com.koshka.origami.model;

import com.firebase.ui.auth.model.*;

import java.util.HashMap;
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
    private HashMap<String,Friend> friendHashMap;
    private Coordinate currentLocation;
    private List<FirstOrigami> origamiList;

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

    public HashMap<String, Friend> getFriendHashMap() {
        return friendHashMap;
    }

    public void setFriendHashMap(HashMap<String, Friend> friendHashMap) {
        this.friendHashMap = friendHashMap;
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

    public List<FirstOrigami> getOrigamiList() {
        return origamiList;
    }

    public void setOrigamiList(List<FirstOrigami> origamiList) {
        this.origamiList = origamiList;
    }
}
