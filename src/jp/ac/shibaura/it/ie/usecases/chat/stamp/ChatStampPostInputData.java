package jp.ac.shibaura.it.ie.usecases.chat.stamp;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatStampPostInputData implements InputData<ChatStampPostOutputData> {
    private final String session;
    private final String roomId;
    private final String messageId;
    private final String stampId;

    public ChatStampPostInputData(String session, String roomId,String messageId, String stampId) {
        this.session = session;
        this.roomId = roomId;
        this.messageId = messageId;
        this.stampId = stampId;
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

    public String getStampId() {
        return stampId;
    }
}
