package jp.ac.shibaura.it.ie.domain.model.image;

import jp.ac.shibaura.it.ie.domain.model.user.User;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {
    public boolean save(String imageId, Image image);
    public void update(User user);
    public List<User> findAll();
    public Optional<Image> find(String imageId);
}
