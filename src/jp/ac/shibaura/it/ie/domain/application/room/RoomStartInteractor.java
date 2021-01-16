package jp.ac.shibaura.it.ie.domain.application.room;

import jp.ac.shibaura.it.ie.domain.model.chat.Chat;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.domain.model.user.*;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartInputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartOutputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartUseCase;
import jp.ac.shibaura.it.ie.usecases.room.start.data.RoomStartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoomStartInteractor implements RoomStartUseCase {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private LogUtils logger;

    @Override
    public RoomStartOutputData handle(RoomStartInputData inputData) {
        RoomStartData roomStartData = inputData.getRoomStartData();
        Room room = new Room(inputData.getRoomId(), inputData.getRoomStartData().getCategoryId());
        for (int i = 0; i < inputData.getRoomStartData().getUsers().size(); i++) {
            room.joinRoom(inputData.getRoomStartData().getUsers().get(i).getSession());
            sessionRepository.save(inputData.getRoomStartData().getUsers().get(i).getSession(), inputData.getRoomStartData().getUsers().get(i).getUserId());
            logger.info("room/start" + inputData.getRoomStartData().getUsers().get(i).getSession() + ":" + inputData.getRoomStartData().getUsers().get(i).getUserId());
        }
        roomRepository.save(room);
        chatRepository.save(inputData.getRoomId(), new Chat(inputData.getRoomId()));

        return new RoomStartOutputData();
    }
}