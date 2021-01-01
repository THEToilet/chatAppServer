package jp.ac.shibaura.it.ie.domain.application.auth;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.usecases.auth.login.AuthLoginOutputData;
import jp.ac.shibaura.it.ie.usecases.auth.login.AuthLoginInputData;
import jp.ac.shibaura.it.ie.usecases.auth.login.AuthLoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AuthLoginInteractor implements AuthLoginUseCase {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public AuthLoginOutputData handle(AuthLoginInputData inputData) {
        String uuid = UUID.randomUUID().toString();
        sessionRepository.save(uuid, inputData.getId());
        return new AuthLoginOutputData(uuid);
    }
}