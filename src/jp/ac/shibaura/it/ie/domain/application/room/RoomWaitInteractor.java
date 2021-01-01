package jp.ac.shibaura.it.ie.domain.application.room;

import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.usecases.room.wait.RoomWaitInputData;
import jp.ac.shibaura.it.ie.usecases.room.wait.RoomWaitOutputData;
import jp.ac.shibaura.it.ie.usecases.room.wait.RoomWaitUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class RoomWaitInteractor implements RoomWaitUseCase {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomWaitOutputData handle(RoomWaitInputData inputData) {
        Optional<Room> room = roomRepository.find(inputData.getRoomId());
        // ここで人数が揃ったらアプリケーションサーバに飛ばす処理を書く
        boolean start = room.get().getNumberOfUser() == room.get().getMaxNumberOfUser();
        if(start){
            //TODO: アプリケーションに送信
            roomRepository.remove(room.get());
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject("http://localhost:8081/app/start", room, Room.class);
        }
        return new RoomWaitOutputData(room.get().getNumberOfUser(), start);
    }
}