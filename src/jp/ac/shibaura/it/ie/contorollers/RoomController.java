package jp.ac.shibaura.it.ie.contorollers;

import jp.ac.shibaura.it.ie.domain.application.room.RoomExitInteractor;
import jp.ac.shibaura.it.ie.domain.application.room.RoomStartInteractor;
import jp.ac.shibaura.it.ie.domain.application.room.RoomWaitInteractor;
import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.room.exit.RoomExitInputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartInputData;
import jp.ac.shibaura.it.ie.usecases.room.wait.RoomWaitInputData;
import jp.ac.shibaura.it.ie.usecases.session.SessionInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomStartInteractor roomStartInteractor;
    @Autowired
    private RoomWaitInteractor roomWaitInteractor;
    @Autowired
    private RoomExitInteractor roomExitInteractor;

    @Autowired
    private SessionInteractor sessionInteractor;

    @Autowired
    private LogUtils logger;

    @RequestMapping(value = "/{roomId}/start", method = RequestMethod.GET)
    public OutputData roomJoin(@RequestHeader("session") String session, @RequestBody RoomStartInputData inputData, @PathVariable("roomId") String roomId) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            logger.info("fdf");
            throw  new RuntimeException();
        }
        return roomStartInteractor.handle(inputData);
    }

    @RequestMapping(value = "/{roomId}/exit", method = RequestMethod.GET)
    public OutputData roomExit(@RequestHeader("session") String session,  @PathVariable("roomId") String roomId) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            logger.info("fdf");
            throw  new RuntimeException();
        }
        return roomExitInteractor.handle(new RoomExitInputData(session, roomId));
    }

    @RequestMapping(value = "/{roomId}/wait", method = RequestMethod.GET)
    public OutputData roomWait(@RequestHeader("session") String session, @PathVariable("roomId") String roomId) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            logger.info("fdf");
            throw  new RuntimeException();
        }
        return roomWaitInteractor.handle(new RoomWaitInputData(session, roomId));
    }
}