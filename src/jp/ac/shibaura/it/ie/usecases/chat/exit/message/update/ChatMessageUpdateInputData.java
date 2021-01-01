package jp.ac.shibaura.it.ie.usecases.chat.exit.message.update;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatMessageUpdateInputData implements InputData<ChatMessageUpdateOutputData> {
    private final String session;
    private final String roomId;

    public ChatMessageUpdateInputData(String session, String roomId) {
        this.session = session;
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getSession() {
        return session;
    }

}
