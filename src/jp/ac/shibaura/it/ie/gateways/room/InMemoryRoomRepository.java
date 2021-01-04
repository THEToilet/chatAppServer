package jp.ac.shibaura.it.ie.gateways.room;

import jp.ac.shibaura.it.ie.domain.model.room.Room;
import jp.ac.shibaura.it.ie.domain.model.room.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryRoomRepository implements RoomRepository {
    private HashMap<String, Room> rooms = new HashMap<>();

    @Override
    public void save(Room room) {
        rooms.put(room.getRoomId(), room);
    }

    @Override
    public void remove(Room room) {
        rooms.remove(room.getRoomId());
    }

    @Override
    public Optional<Room> find(String roomId) {
        return Optional.of(rooms.get(roomId));
    }

    @Override
    public List<Room> findAll(String categoryId) {
        List<Room> tmpRooms = new ArrayList<>();
        for (Iterator<String> iterator = rooms.keySet().iterator(); iterator.hasNext(); ) {
            String key = iterator.next();
            System.out.println(key + " => " + rooms.get(key));
            Room room = rooms.get(key);
            if (room.getCategoryId() == categoryId) {
                tmpRooms.add(room);
            }
        }
        return tmpRooms;

    }

}
