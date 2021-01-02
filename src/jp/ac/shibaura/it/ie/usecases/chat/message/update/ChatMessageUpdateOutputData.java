package jp.ac.shibaura.it.ie.usecases.chat.message.update;

import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import java.util.List;

public class ChatMessageUpdateOutputData implements OutputData {
    private List<Message> messageList;
    public ChatMessageUpdateOutputData(List<Message> messageList) {
        this.messageList = messageList;
    }

    private ChatMessageUpdateOutputData(){}

}
