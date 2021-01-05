package jp.ac.shibaura.it.ie.usecases.chat.stamp;

import jp.ac.shibaura.it.ie.message.StampPostRequest;
import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatStampPostInputData implements InputData<ChatStampPostOutputData> {
    private final String session;
    private final String roomId;
    private final String messageId;
    private final StampPostRequest stampPostRequest;

    public ChatStampPostInputData(String session, String roomId,String messageId, StampPostRequest stampPostRequest) {
        this.session = session;
        this.roomId = roomId;
        this.messageId = messageId;
        this.stampPostRequest = stampPostRequest;
    }

    public String getSession() {
        return session;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getMessageId() {
        return messageId;
    }

    public StampPostRequest getStampPostRequest() {
        return stampPostRequest;
    }
}
