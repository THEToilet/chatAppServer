package jp.ac.shibaura.it.ie.usecases.chat.message.update;

import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import java.util.LinkedHashMap;
import java.util.List;

public class ChatMessageUpdateOutputData implements OutputData {
    private LinkedHashMap<String, Message> messageList;
    public ChatMessageUpdateOutputData(LinkedHashMap<String, Message> messageList) {
        this.messageList = messageList;
    }

    private ChatMessageUpdateOutputData(){}

    public LinkedHashMap<String, Message> getMessageList() {
        return messageList;
    }
}
