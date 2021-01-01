package jp.ac.shibaura.it.ie.domain.model.chat;

import java.util.LinkedHashMap;

public class Chat {
    private String roomId;
    private LinkedHashMap<String, Message> messages = new LinkedHashMap<>();

    public Chat(String roomId) {
        this.roomId = roomId;
    }

    public Message getMessage(String messageId) {
        return messages.get(messageId);
    }

    public void setMessage(String messageId, Message message) {
        messages.put(messageId, message);
    }

    public void updateMessage(String messageId, Message message){
        messages.replace(messageId,message);
    }
}
