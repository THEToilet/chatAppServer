package jp.ac.shibaura.it.ie.contorollers;

import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.auth.entry.AuthEntryInputData;
import jp.ac.shibaura.it.ie.usecases.auth.login.AuthLoginInputData;
import jp.ac.shibaura.it.ie.domain.application.auth.AuthLoginInteractor;
import jp.ac.shibaura.it.ie.domain.application.auth.AuthLogoutInteractor;
import jp.ac.shibaura.it.ie.domain.application.auth.AuthEntryInteractor;
import jp.ac.shibaura.it.ie.usecases.auth.logout.AuthLogoutInputData;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import jp.ac.shibaura.it.ie.usecases.error.ErrorOutputData;
import jp.ac.shibaura.it.ie.usecases.session.SessionInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@EnableAutoConfiguration
@RestController
@Component
public class AuthController {

    @Autowired
    private AuthLoginInteractor authLoginInteractor;

    @Autowired
    private AuthEntryInteractor authEntryInteractor;

    @Autowired
    private AuthLogoutInteractor authLogoutInteractor;

    @Autowired
    private SessionInteractor sessionInteractor;

    @Autowired
    private LogUtils logger;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public OutputData login(@RequestBody AuthLoginInputData inputData) {
        return authLoginInteractor.handle(inputData);
    }

    @RequestMapping(value = "/entry", method = RequestMethod.POST)
    @ResponseBody
    public OutputData entry(@RequestBody AuthEntryInputData inputData) {
        logger.info(inputData.getId()+inputData.getName()+inputData.getPassword());
        logger.info(inputData.toString());
        return authEntryInteractor.handle(inputData);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ResponseBody
    public OutputData logout(@RequestHeader("session") String session) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            throw  new RuntimeException();
        }
        return authLogoutInteractor.handle(new AuthLogoutInputData(session));
    }
}