package jp.ac.shibaura.it.ie.usecases.category.list;

import jp.ac.shibaura.it.ie.domain.model.category.Category;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;

import java.util.ArrayList;
import java.util.List;

public class CategoryListOutputData implements OutputData {
    List<Category> categoryList = new ArrayList<>();
    public CategoryListOutputData(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    private CategoryListOutputData(){}

    public List<Category> getCategoryList(){
        return this.categoryList;
    }

}
