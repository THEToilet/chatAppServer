package jp.ac.shibaura.it.ie.gateways.chat;

import jp.ac.shibaura.it.ie.domain.model.chat.Chat;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class InMemoryChatRepository implements ChatRepository {
    @Override
    public List<Message> findAll(String roomId) {
        return null;
    }

    @Override
    public boolean save(String roomId, Chat chat) {
        return false;
    }

    @Override
    public Optional<Chat> find(String roomId) {
        return Optional.empty();
    }
}
