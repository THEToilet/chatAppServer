package jp.ac.shibaura.it.ie.domain.application.chat.message;

import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.usecases.chat.message.update.ChatMessageUpdateInputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.update.ChatMessageUpdateOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.update.ChatMessageUpdateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChatMessageUpdateInteractor implements ChatMessageUpdateUseCase {
    @Autowired
    private ChatRepository chatRepository;
    @Override
    public ChatMessageUpdateOutputData handle(ChatMessageUpdateInputData inputData) {
        List<Message> messages = chatRepository.findAll(inputData.getRoomId());
        return new ChatMessageUpdateOutputData(messages);
    }
}
