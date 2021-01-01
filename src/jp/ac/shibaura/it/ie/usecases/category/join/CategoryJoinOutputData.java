package jp.ac.shibaura.it.ie.usecases.category.join;

import jp.ac.shibaura.it.ie.domain.model.category.Category;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import java.util.ArrayList;
import java.util.List;

public class CategoryJoinOutputData implements OutputData {
    private String roomId;

    public CategoryJoinOutputData(String roomId) {
        this.roomId = roomId;
    }

    private CategoryJoinOutputData() {
    }

    public String getRoomId() {
        return this.roomId;
    }

}
