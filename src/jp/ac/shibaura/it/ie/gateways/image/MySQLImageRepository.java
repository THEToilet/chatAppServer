package jp.ac.shibaura.it.ie.gateways.image;

import jp.ac.shibaura.it.ie.domain.model.image.ImageRepository;
import jp.ac.shibaura.it.ie.gateways.databese.MySQLComm;
import jp.ac.shibaura.it.ie.log.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySQLImageRepository implements ImageRepository {
    @Autowired
    private LogUtils logger;

    @Override
    public void save(String categoryId, String URL) {
        MySQLComm comm = MySQLComm.getInstance();
        comm.sqlExecuteUpdate(String.format("insert into image(categoryId, url) values ('%s','%s');", categoryId, URL));
    }


    @Override
    public List<String> findAll(String categoryId) {
        List<String> imageList = new ArrayList<>();
        MySQLComm comm = MySQLComm.getInstance();
        ResultSet rs = comm.sqlExecuteQuery(String.format("select * from image where categoryId = '%s';",categoryId));
        try {
            while (rs.next()) {
                imageList.add(rs.getString("url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageList;
    }

}
