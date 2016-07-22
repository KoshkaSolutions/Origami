package com.koshka.origami.model;

/**
 * Created by imuntean on 7/20/16.
 */
public class Friend {

    private String uid;
    private String email;
    private String displayName;

    public Friend() {
    }

    public Friend(String displayName, String uid, String email) {
        this.displayName = displayName;
        this.uid = uid;
        this.email = email;
    }

    public Friend(String email) {
        this.email = email;
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
}
