package jp.ac.shibaura.it.ie.contorollers;

import jp.ac.shibaura.it.ie.domain.application.chat.ChatExitInteractor;
import jp.ac.shibaura.it.ie.domain.application.chat.message.ChatMessagePostInteractor;
import jp.ac.shibaura.it.ie.domain.application.chat.message.ChatMessageUpdateInteractor;
import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.auth.login.AuthLoginInputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.ChatExitInputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.message.post.ChatMessagePostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.exit.message.post.ChatMessagePostUseCase;
import jp.ac.shibaura.it.ie.usecases.chat.exit.message.update.ChatMessageUpdateInputData;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
    private SessionInteractor sessionInteractor;

    @Autowired
    private LogUtils logger;


    @RequestMapping(value = "/{roomId}/message/update", method = RequestMethod.GET)
    @ResponseBody
    public OutputData messageUpdate(@RequestHeader("session") String session, @RequestBody ChatMessageUpdateInputData inputData) {
        return chatMessageUpdateInteractor.handle(inputData);
    }

    @RequestMapping(value = "/{roomId}/message/post", method = RequestMethod.POST)
    @ResponseBody
    public OutputData messagePost(@RequestHeader("session") String session, @RequestBody ChatMessagePostInputData inputData) {
        return chatMessagePostInteractor.handle(inputData);
    }

    @RequestMapping(value = "/{roomId}/exit", method = RequestMethod.GET)
    @ResponseBody
    public OutputData exit(@RequestHeader("session") String session, @RequestParam("roomId") String roomId) {
        return chatExitInteractor.handle(new ChatExitInputData(session));
    }
}