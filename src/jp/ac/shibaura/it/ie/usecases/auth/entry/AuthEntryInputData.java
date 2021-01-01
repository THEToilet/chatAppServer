package jp.ac.shibaura.it.ie.usecases.auth.entry;

import jp.ac.shibaura.it.ie.usecases.core.InputData;

public class AuthEntryInputData implements InputData<AuthEntryOutputData> {
    private final String id;
    private final String name;
    private final String password;

    public AuthEntryInputData(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPassword() {
        return password;
    }
}