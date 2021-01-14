package jp.ac.shibaura.it.ie.domain.application.chat.message;

import com.sun.scenario.effect.ImageData;
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
    private ImagePostInteractor imagePostInteractor;

    @Autowired
    private LogUtils logger;

    @Override
    public ChatMessagePostOutputData handle(ChatMessagePostInputData inputData) {
        ImgurData imgurData = imagePostInteractor.handle(inputData.getImageSource());
        String messageId = UUID.randomUUID().toString();
        Optional<Room> roomOptional = roomRepository.find(inputData.getRoomId());
        if(!roomOptional.isPresent()){
            throw new RuntimeException();
        }
        imageRepository.save(roomOptional.get().getCategoryId(), imgurData.getData().getLink(), inputData.getFileName(), inputData.getFileExtension());

        Optional<Chat> chatOptional = chatRepository.find(inputData.getRoomId());
        if(!chatOptional.isPresent()){
            throw new RuntimeException();
        }
        logger.info("Message/post" + inputData.getSession());
        Optional<User> userOptional = userRepository.find(sessionRepository.find(inputData.getSession()).get());
        if(!userOptional.isPresent()){
            throw new RuntimeException();
        }
        List<Stamp> stampList = new ArrayList<Stamp>();
        // TODO : ここでクソエラー出る
        chatOptional.get().setMessage(messageId, new Message(messageId, userOptional.get().getName().getValue(), imgurData.getData().getLink(), inputData.getFileName(), inputData.getFileExtension(), stampList));

        return new ChatMessagePostOutputData();
    }
}
