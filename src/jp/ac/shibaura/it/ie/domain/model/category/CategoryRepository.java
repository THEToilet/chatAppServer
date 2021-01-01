package jp.ac.shibaura.it.ie.domain.model.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    public void save(Category category);
    public void delete(Category category);
    public List<Category> findAll();
}
