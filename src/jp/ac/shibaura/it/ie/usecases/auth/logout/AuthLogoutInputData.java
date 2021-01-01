package jp.ac.shibaura.it.ie.usecases.auth.logout;

import jp.ac.shibaura.it.ie.usecases.core.InputData;
import jp.ac.shibaura.it.ie.usecases.auth.logout.AuthLogoutOutputData;

public class AuthLogoutInputData implements InputData<AuthLogoutOutputData> {
    private final String session;

    public AuthLogoutInputData(String session) {
        this.session = session;
    }

    public String getSession() {
        return session;
    }

}