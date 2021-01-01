package jp.ac.shibaura.it.ie.usecases.session;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class SessionInputData implements InputData<SessionOutputData> {
    private final String session;

    public SessionInputData(String session) {
        this.session = session;
    }

    public String getSession() {
        return this.session;
    }
}