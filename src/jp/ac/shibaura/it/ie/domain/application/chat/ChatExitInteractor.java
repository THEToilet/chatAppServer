package jp.ac.shibaura.it.ie.domain.application.chat;

import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitInputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ChatExitInteractor implements ChatExitUseCase {
   @Autowired
   private RoomRepository roomRepository;
   @Autowired
   private SessionRepository sessionRepository;
    @Override
    public ChatExitOutputData handle(ChatExitInputData inputData) {
        Optional<Room> room = roomRepository.find(inputData.getRoomId());
        room.get().exitRoom(inputData.getSession());
        sessionRepository.remove(inputData.getSession());
        return new ChatExitOutputData();
    }
}