package jp.ac.shibaura.it.ie.domain.application.chat.message;

import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostInputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostOutputData;
import jp.ac.shibaura.it.ie.usecases.chat.message.post.ChatMessagePostUseCase;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatMessagePostInteractor implements ChatMessagePostUseCase {
    @Override
    public ChatMessagePostOutputData handle(ChatMessagePostInputData inputData) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID aca4e9e2468f686");
        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("image", inputData.getPreImage());
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<MultiValueMap<String,String>>(map,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(" https://api.imgur.com/3/upload", request, String.class);
        System.out.println(response);
        return new ChatMessagePostOutputData();
    }
}
