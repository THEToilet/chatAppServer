package jp.ac.shibaura.it.ie.domain.model.category;

public class Category {
    private int categoryId;
    private String categoryName;
    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
