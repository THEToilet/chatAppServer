package jp.ac.shibaura.it.ie.usecases.chat.exit;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class ChatExitInputData implements InputData<ChatExitOutputData> {
    private final String session;

    public ChatExitInputData(String session) {
        this.session = session;
    }

    public String getSession() {
        return session;
    }

}
