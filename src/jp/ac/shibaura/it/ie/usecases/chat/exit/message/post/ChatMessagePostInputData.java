package jp.ac.shibaura.it.ie.usecases.chat.exit.message.post;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatMessagePostInputData implements InputData<ChatMessagePostOutputData> {
    private final String session;
    private final String roomId;
    private final String preImage;

    public ChatMessagePostInputData(String session, String roomId, String preImage) {
        this.session = session;
        this.roomId = roomId;
        this.preImage = preImage;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getSession() {
        return session;
    }

    public String getPreImage() {
        return preImage;
    }
}
