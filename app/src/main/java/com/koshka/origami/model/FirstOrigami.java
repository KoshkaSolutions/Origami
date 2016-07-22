package com.koshka.origami.model;

import com.firebase.ui.auth.model.*;
import com.firebase.ui.auth.model.Friend;
import com.firebase.ui.auth.model.OrigamiAttachment;

import java.util.List;

/**
 * Created by imuntean on 7/22/16.
 */
public class FirstOrigami extends Origami {
    private String text;
    private int id;
    private String authorUid;
    private String origamiName;
    private String origamiPicture;
    private Coordinate origamiCoordinate;
    private List<OrigamiAttachment> origamiAttachmentList;
    private boolean isPublic;
    private boolean isEphemeral;
    private List<Friend> sentFriendList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorUid() {
        return authorUid;
    }

    public void setAuthorUid(String authorUid) {
        this.authorUid = authorUid;
    }

    public String getOrigamiName() {
        return origamiName;
    }

    public void setOrigamiName(String origamiName) {
        this.origamiName = origamiName;
    }

    public Coordinate getOrigamiCoordinate() {
        return origamiCoordinate;
    }

    public void setOrigamiCoordinate(Coordinate origamiCoordinate) {
        this.origamiCoordinate = origamiCoordinate;
    }

    public List<OrigamiAttachment> getOrigamiAttachmentList() {
        return origamiAttachmentList;
    }

    public void setOrigamiAttachmentList(List<OrigamiAttachment> origamiAttachmentList) {
        this.origamiAttachmentList = origamiAttachmentList;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public boolean isEphemeral() {
        return isEphemeral;
    }

    public void setEphemeral(boolean ephemeral) {
        isEphemeral = ephemeral;
    }

    public List<Friend> getSentFriendList() {
        return sentFriendList;
    }

    public void setSentFriendList(List<Friend> sentFriendList) {
        this.sentFriendList = sentFriendList;
    }

    public FirstOrigami() {
        super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
