package jp.ac.shibaura.it.ie.usecases.room.wait;

import jp.ac.shibaura.it.ie.usecases.core.OutputData;

public class RoomWaitOutputData implements OutputData {
    private int numberOfWaitUser;
    private boolean start;

    public RoomWaitOutputData(int numberOfWaitUser, boolean start) {
        this.numberOfWaitUser = numberOfWaitUser;
        this.start = start;
    }

    private RoomWaitOutputData() {}

    public boolean isStart() {
        return start;
    }

    public int getNumberOfWaitUser() {
        return numberOfWaitUser;
    }
}
