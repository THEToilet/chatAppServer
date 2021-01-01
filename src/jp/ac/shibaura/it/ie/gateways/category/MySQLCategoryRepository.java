package jp.ac.shibaura.it.ie.gateways.category;

import jp.ac.shibaura.it.ie.domain.model.category.Category;
import jp.ac.shibaura.it.ie.domain.model.category.CategoryRepository;
import jp.ac.shibaura.it.ie.gateways.databese.MySQLComm;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySQLCategoryRepository implements CategoryRepository {
    @Override
    public void save(Category category) {
        MySQLComm comm = MySQLComm.getInstance();
        comm.sqlExecuteUpdate(String.format("insert into category (id, name) values (%d,'%s');", category.getCategoryId(), category.getCategoryName()));
    }

    @Override
    public void delete(Category category) {
        MySQLComm comm = MySQLComm.getInstance();
        comm.sqlExecuteUpdate(String.format("delete category where id = %s;", category.getCategoryId()));
    }

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        MySQLComm comm = MySQLComm.getInstance();
        ResultSet rs = comm.sqlExecuteQuery("select * from category;");
        try {
            while (rs.next()) {
                Category category = new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                categoryList.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }

}
