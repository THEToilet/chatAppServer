package jp.ac.shibaura.it.ie.gateways.session;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Optional;

@Component
public class InMemorySessionRepository implements SessionRepository {
    private HashMap<String, String> sessions = new HashMap<>();
    @Override
    public void save(String session, String userId) {
        sessions.put(session,userId);
    }

    @Override
    public void remove(String session) {
        sessions.remove(session);
    }

    @Override
    public Optional<String> find(String session) {
        return Optional.of(sessions.get(session));
    }

}
