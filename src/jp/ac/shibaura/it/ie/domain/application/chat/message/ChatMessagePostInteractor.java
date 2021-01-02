package jp.ac.shibaura.it.ie.domain.application.chat.message;

import jp.ac.shibaura.it.ie.config.Config;
import jp.ac.shibaura.it.ie.domain.model.chat.ChatRepository;
import jp.ac.shibaura.it.ie.domain.model.chat.Message;
import jp.ac.shibaura.it.ie.domain.model.image.ImageRepository;
import jp.ac.shibaura.it.ie.domain.model.imgur.ImgurData;
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

import java.util.UUID;

@Component
public class ChatMessagePostInteractor implements ChatMessagePostUseCase {
    @Autowired
    private ChatRepository chatRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Override
    public ChatMessagePostOutputData handle(ChatMessagePostInputData inputData) {
        RestTemplate restTemplate = new RestTemplate();

        // header設定
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID " + Config.get().getClientId());

        // body設定
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", inputData.getPreImage());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);
        System.out.println(request.toString());

        ResponseEntity<ImgurData> response = restTemplate.postForEntity("https://api.imgur.com/3/image", request, ImgurData.class);
        System.out.println(response);
        System.out.println(response.getBody().getData().getLink());

        imageRepository.save(UUID.randomUUID().toString(), response.getBody().getData().getLink());
        chatRepository.find(inputData.getRoomId()).get().setMessage(UUID.randomUUID().toString(), new Message(UUID.randomUUID().toString(),"userName", response.getBody().getData().getLink()));

        return new ChatMessagePostOutputData();
    }
}
