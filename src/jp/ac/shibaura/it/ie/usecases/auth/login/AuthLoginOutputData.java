package jp.ac.shibaura.it.ie.usecases.auth.login;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class AuthLoginOutputData implements OutputData {
    private String session;

    public AuthLoginOutputData(String session) {
        this.session = session;
    }

    private AuthLoginOutputData() {
    }


    public String getSession() {
        return session;
    }
}
