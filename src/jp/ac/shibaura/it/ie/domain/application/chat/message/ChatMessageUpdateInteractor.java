package jp.ac.shibaura.it.ie.domain.application.chat.message;

import jp.ac.shibaura.it.ie.usecases.chat.exit.message.update.ChatMessageUpdateInputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.message.update.ChatMessageUpdateOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.message.update.ChatMessageUpdateUseCase;

public class ChatMessageUpdateInteractor implements ChatMessageUpdateUseCase {
    @Override
    public ChatMessageUpdateOutputData handle(ChatMessageUpdateInputData inputData) {
        return new ChatMessageUpdateOutputData();
    }
}
