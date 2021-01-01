package jp.ac.shibaura.it.ie.domain.application.category;

import com.google.inject.Inject;
import jp.ac.shibaura.it.ie.domain.model.category.CategoryRepository;
import jp.ac.shibaura.it.ie.usecases.category.list.CategoryListOutputData;
import jp.ac.shibaura.it.ie.usecases.category.list.CategoryListInputData;
import jp.ac.shibaura.it.ie.usecases.category.list.CategoryListUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryListInteractor implements CategoryListUseCase {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryListOutputData handle(CategoryListInputData inputData) {
        return new CategoryListOutputData(categoryRepository.findAll());
    }
}