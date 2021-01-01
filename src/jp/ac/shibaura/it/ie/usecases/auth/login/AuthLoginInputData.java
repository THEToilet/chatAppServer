package jp.ac.shibaura.it.ie.usecases.auth.login;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class AuthLoginInputData implements InputData<AuthLoginOutputData> {
    private final String id;
    private final String password;

    public AuthLoginInputData(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}