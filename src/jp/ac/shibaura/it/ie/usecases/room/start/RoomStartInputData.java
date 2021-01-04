package jp.ac.shibaura.it.ie.usecases.room.start;

import jp.ac.shibaura.it.ie.usecases.core.InputData;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;
import jp.ac.shibaura.it.ie.usecases.room.start.data.RoomStartData;

import java.awt.im.spi.InputMethod;
import java.util.ArrayList;
import java.util.List;

public class RoomStartInputData implements InputData {
    private RoomStartData roomStartData;
    private String roomId;
    public RoomStartInputData(RoomStartData roomStartData, String roomId){
        this.roomId = roomId;
        this.roomStartData = roomStartData;
    }

    public RoomStartData getRoomStartData() {
        return this.roomStartData;
    }

    public String getRoomId() {
        return this.roomId;
    }
}
