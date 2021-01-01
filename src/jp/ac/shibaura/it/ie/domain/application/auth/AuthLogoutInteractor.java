package jp.ac.shibaura.it.ie.domain.application.auth;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.usecases.auth.logout.AuthLogoutInputData;
import jp.ac.shibaura.it.ie.usecases.auth.logout.AuthLogoutOutputData;
import jp.ac.shibaura.it.ie.usecases.auth.logout.AuthLogoutUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthLogoutInteractor implements AuthLogoutUseCase {

    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public AuthLogoutOutputData handle(AuthLogoutInputData inputData) {
        sessionRepository.remove(inputData.getSession());
        return new AuthLogoutOutputData(true);
    }
}
