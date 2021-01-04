package jp.ac.shibaura.it.ie.usecases.room.start.data;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import java.util.ArrayList;
import java.util.List;

public class RoomStartData {
    private List<RoomStartUserData> users = new ArrayList<>();
    private String categoryId;

    public RoomStartData(List<RoomStartUserData> users, String categoryId) {
        this.users = users;
        this.categoryId = categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryId() {
        return this.categoryId;
    }

    public List<RoomStartUserData> getUsers() {
        return this.users;
    }

    public void setUsers(List<RoomStartUserData> users) {
        this.users = users;
    }
}
