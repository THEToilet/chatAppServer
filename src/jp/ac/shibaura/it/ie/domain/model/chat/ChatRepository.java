package jp.ac.shibaura.it.ie.domain.model.chat;

import jp.ac.shibaura.it.ie.domain.model.image.Image;
import jp.ac.shibaura.it.ie.domain.model.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ChatRepository {
    public boolean save(String roomId, Chat chat);
    public Optional<Chat> find(String roomId);
    public List<Message> findAll(String roomId);
}
