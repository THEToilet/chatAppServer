package jp.ac.shibaura.it.ie.domain.model.chat;

import java.util.List;

public class Message {
    private String messageId;
    private String postedUser;
    private String imageId;
    private List<Stamp> stampList;
    public Message(String messageId, String postedUser, String imageId){
        this.messageId = messageId;
        this.postedUser = postedUser;
        this.imageId = imageId;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getImageId() {
        return imageId;
    }

    public String getPostedUser() {
        return postedUser;
    }
}
