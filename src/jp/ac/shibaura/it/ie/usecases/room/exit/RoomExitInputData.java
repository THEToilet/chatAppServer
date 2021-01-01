package jp.ac.shibaura.it.ie.usecases.room.exit;

import jp.ac.shibaura.it.ie.domain.model.user.UserPassword;
import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class RoomExitInputData implements InputData<RoomExitOutputData> {
    private final String session;
    private final String roomId;

    public RoomExitInputData(String session, String roomId) {
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
