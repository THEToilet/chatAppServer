package jp.ac.shibaura.it.ie.domain.model.room;

import jp.ac.shibaura.it.ie.domain.model.category.Category;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {
    public void save (Room room);
    public void remove(Room room);
    public List<Room> findAll(String categoryId);
    public Optional<Room> find(String roomId);
}

