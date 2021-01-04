package jp.ac.shibaura.it.ie.usecases.room.start.data;

public class RoomStartUserData {
    private String userId;
    private String userName;
    private String session;

    public RoomStartUserData(String userId, String userName, String session){
        this.userId = userId;
        this.userName = userName;
        this.session = session;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getSession() {
        return this.session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
