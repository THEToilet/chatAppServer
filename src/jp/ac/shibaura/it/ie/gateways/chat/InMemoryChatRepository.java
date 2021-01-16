package jp.ac.shibaura.it.ie.gateways.chat;

import jp.ac.shibaura.it.ie.domain.model.chat.Chat;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class InMemoryChatRepository implements ChatRepository {
    private Map<String, Chat> chatMap = new LinkedHashMap<>();

    @Override
    public void save(String roomId, Chat chat) {
        chatMap.put(roomId, chat);
    }

    @Override
    public Optional<Chat> find(String roomId) {
        return Optional.ofNullable(chatMap.get(roomId));
    }
}
