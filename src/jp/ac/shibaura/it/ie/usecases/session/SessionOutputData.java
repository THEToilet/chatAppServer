package jp.ac.shibaura.it.ie.usecases.session;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class SessionOutputData implements OutputData {
    private Boolean success;

    public SessionOutputData(Boolean success) {
        this.success = success;
    }

    private SessionOutputData() {
    }

    public Boolean isSuccess() {
        return this.success;
    }
}
