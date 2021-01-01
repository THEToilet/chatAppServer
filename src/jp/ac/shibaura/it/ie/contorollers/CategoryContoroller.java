package jp.ac.shibaura.it.ie.contorollers;

import jp.ac.shibaura.it.ie.domain.application.category.CategoryJoinInteractor;
import jp.ac.shibaura.it.ie.domain.application.category.CategoryListInteractor;
import jp.ac.shibaura.it.ie.domain.application.session.SessionInteractor;
import jp.ac.shibaura.it.ie.log.LogUtils;
import jp.ac.shibaura.it.ie.usecases.category.join.CategoryJoinInputData;
import jp.ac.shibaura.it.ie.usecases.category.list.CategoryListInputData;
import jp.ac.shibaura.it.ie.usecases.core.OutputData;
import jp.ac.shibaura.it.ie.usecases.session.SessionInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@EnableAutoConfiguration
@RestController
@RequestMapping("/category")
public class CategoryContoroller {

    @Autowired
    private CategoryListInteractor categoryListInteractor;
    @Autowired
    private CategoryJoinInteractor categoryJoinInteractor;
    @Autowired
    private SessionInteractor sessionInteractor;
    @Autowired
    private LogUtils logger;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public OutputData categoryList(@RequestHeader("session") String session) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            logger.info("fdf");
            throw  new RuntimeException();
        }
        return categoryListInteractor.handle(new CategoryListInputData());
    }

    @RequestMapping(value = "/{categoryId}/join", method = RequestMethod.GET)
    public OutputData categoryJoin(@RequestHeader("session") String session, @PathVariable("categoryId") String categoryId) {
        if(!sessionInteractor.handle(new SessionInputData(session)).isSuccess()){
            logger.info("fdf");
            throw  new RuntimeException();
        }
        return categoryJoinInteractor.handle(new CategoryJoinInputData(session, categoryId));
    }
}