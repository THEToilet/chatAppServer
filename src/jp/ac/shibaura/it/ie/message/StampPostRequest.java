package jp.ac.shibaura.it.ie.message;

public class StampPostRequest {
    private String userName;
    private String stampId;

    public StampPostRequest(String userName, String stampId) {
        this.userName = userName;
        this.stampId = stampId;
    }

    public String getStampId() {
        return stampId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setStampId(String stampId) {
        this.stampId = stampId;
    }
}
