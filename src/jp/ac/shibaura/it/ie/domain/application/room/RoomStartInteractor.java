package jp.ac.shibaura.it.ie.domain.application.room;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.chat.Chat;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.domain.model.user.*;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartInputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartOutputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RoomStartInteractor implements RoomStartUseCase {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public RoomStartOutputData handle(RoomStartInputData inputData) {
        List<User> users = inputData.getUsers();
        List<String> sessions = inputData.getSessions();
        Room room = new Room(inputData.getRoomId(), inputData.getCategoryId());
        roomRepository.save(room);
        for(int i=0;i<sessions.size();i++){
            sessionRepository.save(sessions.get(i),users.get(i).getId().getValue());
        }
        chatRepository.save(inputData.getRoomId(), new Chat(inputData.getRoomId()));

        return new RoomStartOutputData();
    }
}