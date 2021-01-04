package jp.ac.shibaura.it.ie.contorollers;

import jp.ac.shibaura.it.ie.domain.application.chat.ChatExitInteractor;
import jp.ac.shibaura.it.ie.domain.application.chat.message.ChatMessagePostInteractor;
import jp.ac.shibaura.it.ie.domain.application.chat.message.ChatMessageUpdateInteractor;
import jp.ac.shibaura.it.ie.domain.application.chat.stamp.ChatStampPostInteractor;
import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.message.MessagePostRequest;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitInputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.update.ChatMessageUpdateInputData;
import jp.ac.shibaura.it.ie.usecases.chat.stamp.ChatStampPostInputData;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@EnableAutoConfiguration
@RestController
@Component
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatMessageUpdateInteractor chatMessageUpdateInteractor;

    @Autowired
    private ChatMessagePostInteractor chatMessagePostInteractor;

    @Autowired
    private ChatExitInteractor chatExitInteractor;

    @Autowired
    private ChatStampPostInteractor chatStampPostInteractor;

    @Autowired
    private SessionInteractor sessionInteractor;

    @Autowired
    private LogUtils logger;


    @RequestMapping(value = "/{roomId}/message/update", method = RequestMethod.GET)
    public OutputData messageUpdate(@RequestHeader("session") String session, @PathVariable("roomId") String roomId) {
        return chatMessageUpdateInteractor.handle(new ChatMessageUpdateInputData(session, roomId));
    }

    // roomIdのチャットを更新　あと画像は変換して送り返す
    // そして新しいメッセージIdを返す
    @RequestMapping(value = "/{roomId}/message/post", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> messagePost(@RequestHeader("session") String session, @PathVariable("roomId") String roomId, @RequestBody MessagePostRequest messagePostRequest) {
        logger.info(messagePostRequest.getImageSource() + ":" + messagePostRequest.getFileName() + ":" + messagePostRequest.getFileExtension());
        chatMessagePostInteractor.handle(new ChatMessagePostInputData(session, roomId, messagePostRequest.getImageSource(), messagePostRequest.getFileName(), messagePostRequest.getFileExtension()));
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/{roomId}/{messageId}/stamp/post", method = RequestMethod.POST)
    @ResponseBody
    public OutputData stampPost(@RequestHeader("session") String session, @RequestHeader("messageId") String messageId, @RequestHeader("roomId") String roomId, @RequestParam("stampId") String stampId) {
        return chatStampPostInteractor.handle(new ChatStampPostInputData(session, roomId, messageId, stampId));
    }

    @RequestMapping(value = "/{roomId}/exit", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> exit(@RequestHeader("session") String session, @RequestHeader("roomId") String roomId) {
        chatExitInteractor.handle(new ChatExitInputData(session, roomId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}