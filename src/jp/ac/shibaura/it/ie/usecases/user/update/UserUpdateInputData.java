package jp.ac.shibaura.it.ie.usecases.user.update;
import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class UserUpdateInputData implements InputData<UserUpdateOutputData> {
    private final String userId;
    private final String userName;


    public UserUpdateInputData(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getUserId() {
        return this.userId;
    }
}
