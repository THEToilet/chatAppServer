package jp.ac.shibaura.it.ie.usecases.room.start;

import jp.ac.shibaura.it.ie.domain.model.user.User;
import jp.ac.shibaura.it.ie.domain.model.user.UserPassword;
import jp.ac.shibaura.it.ie.usecases.core.InputData;

import java.util.List;

public class RoomStartInputData implements InputData<RoomStartOutputData> {
    private final List<User> users;
    private final List<String> sessions;
    private final String roomId;
    private final String categoryId;

    public RoomStartInputData(List<User> users, List<String> sessions, String roomId, String categoryId) {
        this.users = users;
        this.sessions = sessions;
        this.roomId = roomId;
        this.categoryId = categoryId;
    }

    public String getRoomId() {
        return roomId;
    }

    public List<String> getSessions() {
        return this.sessions;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public String getCategoryId() {
        return categoryId;
    }
}
