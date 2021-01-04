package jp.ac.shibaura.it.ie.domain.application.chat.stamp;

import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatStampPostInteractor implements ChatStampPostUseCase {
    @Autowired
    private ChatRepository chatRepository;
    @Override
    public ChatStampPostOutputData handle(ChatStampPostInputData inputData) {
        //List<Message> messages = chatRepository.findAll(inputData.getRoomId());
        return new ChatStampPostOutputData();
    }
}
