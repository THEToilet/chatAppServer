package jp.ac.shibaura.it.ie.usecases.error;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class ErrorOutputData implements OutputData {
    private String message;

    public ErrorOutputData(String message) {
        this.message = message;
    }

    private ErrorOutputData() {}

    public String getMessage() {
        return message;
    }
}
