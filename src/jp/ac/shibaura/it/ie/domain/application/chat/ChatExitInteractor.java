package jp.ac.shibaura.it.ie.domain.application.chat;

import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitInputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitUseCase;

public class ChatExitInteractor implements ChatExitUseCase {
    @Override
    public ChatExitOutputData handle(ChatExitInputData inputData) {
        return new ChatExitOutputData();
    }
}