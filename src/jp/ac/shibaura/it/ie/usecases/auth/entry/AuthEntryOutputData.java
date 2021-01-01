package jp.ac.shibaura.it.ie.usecases.auth.entry;


import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class AuthEntryOutputData implements OutputData {
    private boolean success;

    public AuthEntryOutputData(boolean success) {
        this.success = success;
    }

    private AuthEntryOutputData(){

    }

    public boolean isSuccess() {
        return success;
    }

}
