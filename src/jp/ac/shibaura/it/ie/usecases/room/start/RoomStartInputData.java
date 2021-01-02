package jp.ac.shibaura.it.ie.usecases.room.start;

import jp.ac.shibaura.it.ie.domain.model.user.User;
import jp.ac.shibaura.it.ie.domain.model.user.UserSession;
import jp.ac.shibaura.it.ie.usecases.core.InputData;

import java.util.List;

public class RoomStartInputData implements InputData<RoomStartOutputData> {
    private final List<UserSession> users;
    private final String roomId;
    private final String categoryId;

    public RoomStartInputData(List<UserSession> users, List<String> sessions, String roomId, String categoryId) {
        this.users = users;
        this.roomId = roomId;
        this.categoryId = categoryId;
    }

    public String getRoomId() {
        return roomId;
    }


    public List<UserSession> getUsers() {
        return this.users;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
