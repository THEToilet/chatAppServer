package jp.ac.shibaura.it.ie.domain.model.image;

import jp.ac.shibaura.it.ie.domain.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {
    public void save(String categoryId, String URL, String fileName, String fileExtension);
    public List<String> findAll(String categoryId);
}
