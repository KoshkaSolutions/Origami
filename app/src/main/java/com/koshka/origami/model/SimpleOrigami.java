package com.koshka.origami.model;

import java.util.List;

/**
 * Created by imuntean on 7/20/16.
 */
public class SimpleOrigami extends Origami {

    private String text;
    private String author_uid;
    private List<OrigamiAttachment> origamiAttachmentList;

    public SimpleOrigami() {
        super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
