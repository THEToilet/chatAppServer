package jp.ac.shibaura.it.ie.contorollers;

import jp.ac.shibaura.it.ie.domain.application.room.RoomStartInteractor;
import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartInputData;
import jp.ac.shibaura.it.ie.usecases.room.start.data.RoomStartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("room")
public class RoomController {

    @Autowired
    private RoomStartInteractor roomStartInteractor;

    @Autowired
    private SessionInteractor sessionInteractor;

    @Autowired
    private LogUtils logger;

    @RequestMapping(value = "/{roomId}/start", method = RequestMethod.POST)
    public ResponseEntity<String> roomJoin(@RequestBody RoomStartData inputData, @PathVariable("roomId") String roomId) {
        roomStartInteractor.handle(new RoomStartInputData(inputData, roomId));
        logger.info("Room/Start:" + inputData.toString());
        logger.info("Room/Start" + inputData.getCategoryId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}