package jp.ac.shibaura.it.ie.usecases.room.start;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class RoomStartOutputData implements OutputData {
    private String userId;

    public RoomStartOutputData(String userId) {
        this.userId = userId;
    }

    private RoomStartOutputData() {}

    public String getUserId() {
        return userId;
    }
}
