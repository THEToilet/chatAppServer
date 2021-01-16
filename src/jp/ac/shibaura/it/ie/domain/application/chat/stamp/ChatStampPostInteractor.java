package jp.ac.shibaura.it.ie.domain.application.chat.stamp;

import jp.ac.shibaura.it.ie.domain.model.chat.Chat;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.domain.model.chat.Stamp;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ChatStampPostInteractor implements ChatStampPostUseCase {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public ChatStampPostOutputData handle(ChatStampPostInputData inputData) {
        Optional<Chat> chatOptional = chatRepository.find(inputData.getRoomId());
        if(!chatOptional.isPresent()){
            throw new RuntimeException();
        }
        Message message = chatOptional.get().getMessageMap().get(inputData.getMessageId());
        message.getStampList().add(new Stamp(inputData.getStampPostRequest().getUserName(), inputData.getStampPostRequest().getStampId()));
        return new ChatStampPostOutputData();
    }
}
