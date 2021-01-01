package jp.ac.shibaura.it.ie.usecases.room.start;

import jp.ac.shibaura.it.ie.domain.model.user.UserPassword;
import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class RoomStartInputData implements InputData<RoomStartOutputData> {
    private final String session;
    private final String userId;
    private final String roomId;

    public RoomStartInputData(String session, String userId, String roomId) {
        this.session = session;
        this.userId = userId;
        this.roomId = roomId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getSession() {
        return session;
    }

    public String getUserId() {
        return userId;
    }
}
