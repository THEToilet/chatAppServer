package jp.ac.shibaura.it.ie.domain.application.session;


import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.usecases.session.SessionInputData;
import jp.ac.shibaura.it.ie.usecases.session.SessionOutputData;
import jp.ac.shibaura.it.ie.usecases.session.SessionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionInteractor implements SessionUseCase {
    @Autowired
    private SessionRepository sessionRepository;

    @Override
    public SessionOutputData handle(SessionInputData inputData) {
        return new SessionOutputData(sessionRepository.find(inputData.getSession()).isPresent());
    }
}