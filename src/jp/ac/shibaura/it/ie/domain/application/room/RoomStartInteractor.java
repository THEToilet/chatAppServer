package jp.ac.shibaura.it.ie.domain.application.room;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.user.*;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartInputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartOutputData;
import jp.ac.shibaura.it.ie.usecases.room.start.RoomStartUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RoomStartInteractor implements RoomStartUseCase {
    @Autowired
    private UserRepository userRepository;

    @Override
    public RoomStartOutputData handle(RoomStartInputData inputData) {

        return new RoomStartOutputData("f");
    }
}