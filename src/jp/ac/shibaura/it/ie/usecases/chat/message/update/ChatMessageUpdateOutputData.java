package jp.ac.shibaura.it.ie.usecases.chat.message.update;

import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ChatMessageUpdateOutputData implements OutputData {
    private Map<String, Message> messageList = new LinkedHashMap<String, Message>();

    public ChatMessageUpdateOutputData(Map<String, Message> messageList) {
        this.messageList = messageList;
    }

    private ChatMessageUpdateOutputData() {
    }

    public Map<String, Message> getMessageList() {
        return messageList;
    }
}
