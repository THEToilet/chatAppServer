package jp.ac.shibaura.it.ie.usecases.auth.logout;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class AuthLogoutOutputData implements OutputData {
    private boolean success;

    public AuthLogoutOutputData(boolean success) {
        this.success = success;
    }

    private AuthLogoutOutputData() {
    }

    public boolean isSuccess() {
        return success;
    }
}
