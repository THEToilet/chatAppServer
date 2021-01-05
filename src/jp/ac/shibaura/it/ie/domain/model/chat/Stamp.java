package jp.ac.shibaura.it.ie.domain.model.chat;

public class Stamp {
    private String postedUser;
    private String stampId;
    public Stamp(String postedUser, String stampId){
       this.postedUser = postedUser;
       this.stampId = stampId;
    }

    public String getPostedUser() {
        return postedUser;
    }

    public String getStampId() {
        return stampId;
    }

    public void setStampId(String stampId) {
        this.stampId = stampId;
    }

    public void setPostedUser(String postedUser) {
        this.postedUser = postedUser;
    }
}
