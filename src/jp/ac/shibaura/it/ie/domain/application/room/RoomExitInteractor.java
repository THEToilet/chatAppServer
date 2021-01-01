package jp.ac.shibaura.it.ie.domain.application.room;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.domain.model.user.*;
import jp.ac.shibaura.it.ie.usecases.room.exit.RoomExitInputData;
import jp.ac.shibaura.it.ie.usecases.room.exit.RoomExitOutputData;
import jp.ac.shibaura.it.ie.usecases.room.exit.RoomExitUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class RoomExitInteractor implements RoomExitUseCase {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public RoomExitOutputData handle(RoomExitInputData inputData) {

        Optional<Room> room = roomRepository.find(inputData.getRoomId());
        room.get().exitRoom(inputData.getSession());

        return new RoomExitOutputData();
    }
}