package jp.ac.shibaura.it.ie.usecases.chat.exit;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatExitInputData implements InputData<ChatExitOutputData> {
    private final String session;
    private final String roomId;

    public ChatExitInputData(String session, String roomId) {
        this.session = session;
        this.roomId = roomId;
    }

    public String getSession() {
        return session;
    }

    public String getRoomId() {
        return roomId;
    }
}
