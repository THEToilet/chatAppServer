package jp.ac.shibaura.it.ie.contorollers;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.domain.application.user.UserUpdateInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;
import jp.ac.shibaura.it.ie.usecases.session.SessionInputData;
import jp.ac.shibaura.it.ie.usecases.user.update.UserUpdateInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserUpdateInteractor userUpdateInteractor;

    @Autowired
    private SessionInteractor sessionInteractor;

    @Autowired
    private LogUtils logger;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public OutputData userUpdate(@RequestParam("session") String session, @RequestBody UserUpdateInputData inputDate) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            logger.info("fdf");
            throw  new RuntimeException();
        }
        return userUpdateInteractor.handle(inputDate);
    }
}