package jp.ac.shibaura.it.ie.domain.model.room;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private List<String> users = new ArrayList<>(4);
    private String roomId;
    private String categoryId;
    private long creationTime;

    @Autowired
    RoomRepository roomRepository;

    public Room(String roomId, String categoryId){
        this.roomId = roomId;
        this.categoryId = categoryId;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getCategoryId(){
        return this.categoryId;
    }

    public int getNumberOfUser(){
       return users.size();
    }
    public int getMaxNumberOfUser(){
        return 4;
    }

    public void joinRoom(String session){
        users.add(session);
    }
    public void exitRoom(String session){
        users.remove(session);
    }

}
