package jp.ac.shibaura.it.ie.domain.application.chat.message;

import jp.ac.shibaura.it.ie.config.Config;
import jp.ac.shibaura.it.ie.domain.model.imgur.ImgurData;
import jp.ac.shibaura.it.ie.log.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class ImagePostInteractor {
    @Autowired
    private LogUtils logger;

    public ImgurData handle(String imageSource) {
        RestTemplate restTemplate = new RestTemplate();

        // header設定
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Client-ID " + Config.get().getClientId());

        // body設定
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("image", imageSource);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(body, headers);

        ResponseEntity<ImgurData> response = restTemplate.postForEntity("https://api.imgur.com/3/image", request, ImgurData.class);
        logger.info(response.toString());
        logger.info(response.getBody().getData().getLink());
        return response.getBody();
    }
}
