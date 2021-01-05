package jp.ac.shibaura.it.ie.domain.application.chat.message;

import jp.ac.shibaura.it.ie.config.Config;
import jp.ac.shibaura.it.ie.domain.model.chat.Chat;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.domain.model.chat.Stamp;
import jp.ac.shibaura.it.ie.domain.model.image.ImageRepository;
import jp.ac.shibaura.it.ie.domain.model.imgur.ImgurData;
import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import jp.ac.shibaura.it.ie.domain.model.session.SessionRepository;
import jp.ac.shibaura.it.ie.domain.model.user.User;
import jp.ac.shibaura.it.ie.domain.model.user.UserRepository;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ChatMessagePostInteractor implements ChatMessagePostUseCase {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private LogUtils logger;

    @Override
    public ChatMessagePostOutputData handle(ChatMessagePostInputData inputData) {
        RestTemplate restTemplate = new RestTemplate();

        // header設定
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID " + Config.get().getClientId());

        // body設定
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", inputData.getImageSource());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);
        logger.info("chat/message/post" + request.toString());

        ResponseEntity<ImgurData> response = restTemplate.postForEntity("https://api.imgur.com/3/image", request, ImgurData.class);
        logger.info(response.toString());
        logger.info(response.getBody().getData().getLink());

        String messageId = UUID.randomUUID().toString();
        imageRepository.save(roomRepository.find(inputData.getRoomId()).get().getCategoryId(), response.getBody().getData().getLink());
        Optional<Chat> chat = chatRepository.find(inputData.getRoomId());
        logger.info("Message/post" + inputData.getSession());
        Optional<User> user = userRepository.find(sessionRepository.find(inputData.getSession()).get());
        List<Stamp> stampList = new ArrayList<Stamp>();
        chat.get().setMessage(messageId, new Message(messageId, user.get().getName().getValue(), response.getBody().getData().getLink(), inputData.getFileName(), inputData.getFileExtension(), stampList));

        return new ChatMessagePostOutputData();
    }
}
