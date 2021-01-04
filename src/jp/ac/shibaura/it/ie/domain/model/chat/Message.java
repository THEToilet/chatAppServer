package jp.ac.shibaura.it.ie.domain.model.chat;

import java.util.List;

public class Message {
    private String messageId;
    private String postedUser;
    private String imageUrl;
    private String fileName;
    private String fileExtension;
    private List<Stamp> stampList;
    public Message(String messageId, String postedUser, String imageUrl, String fileName, String fileExtension){
        this.messageId = messageId;
        this.postedUser = postedUser;
        this.imageUrl = imageUrl;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getImageId() {
        return imageUrl;
    }

    public String getPostedUser() {
        return postedUser;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public String getFileName() {
        return fileName;
    }
}
