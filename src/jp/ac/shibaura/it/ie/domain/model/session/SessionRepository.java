package jp.ac.shibaura.it.ie.domain.model.session;

import jp.ac.shibaura.it.ie.domain.model.user.User;

import java.util.Optional;

public interface SessionRepository {
    public void save(String session, String userId);
    public void remove(String session);
    public Optional<String> find(String session);
}
