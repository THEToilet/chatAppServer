package jp.ac.shibaura.it.ie.domain.model.chat;

import java.util.ArrayList;
import java.util.List;

public class Message {
    private String messageId;
    private String postedUser;
    private String imageUrl;
    private String fileName;
    private String fileExtension;
    private List<Stamp> stampList = new ArrayList<Stamp>();

    public Message(String messageId, String postedUser, String imageUrl, String fileName, String fileExtension, List<Stamp> stampList) {
        this.messageId = messageId;
        this.postedUser = postedUser;
        this.imageUrl = imageUrl;
        this.fileName = fileName;
        this.fileExtension = fileExtension;
        this.stampList = stampList;
    }


    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPostedUser(String postedUser) {
        this.postedUser = postedUser;
    }

    public String getMessageId() {
        return messageId;
    }

    public String getImageUrl() {
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

    public void setStampList(List<Stamp> stampList) {
        this.stampList = stampList;
    }

    public List<Stamp> getStampList() {
        return stampList;
    }
}
