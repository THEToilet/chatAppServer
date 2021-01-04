package jp.ac.shibaura.it.ie.gateways.user;

import jp.ac.shibaura.it.ie.domain.model.user.*;
import jp.ac.shibaura.it.ie.gateways.databese.MySQLComm;
import jp.ac.shibaura.it.ie.log.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MySQLUserRepository implements UserRepository {
    @Autowired
    private LogUtils logger;
    @Override
    public boolean save(User user) {
        MySQLComm comm = MySQLComm.getInstance();
        logger.info(String.format("insert into user(id, name, password) values (%s,%s,%s);", user.getId().getValue(), user.getName().getValue(), user.getPass().getValue()));
        //comm.sqlExecuteUpdate(String.format("insert into user(id, name, password) values (%s,%s,%s);", user.getId().getValue(), user.getName().getValue(), user.getPass().getValue()));
        return comm.sqlExecuteUpdate(String.format("insert into user(id, name, password) values ('%s','%s','%s');", user.getId().getValue(), user.getName().getValue(), user.getPass().getValue()));
    }

    @Override
    public void update(User user) {
        MySQLComm comm = MySQLComm.getInstance();
        comm.sqlExecuteUpdate(String.format("update user set name = '%s' where id = '%s';", user.getName().getValue(), user.getId().getValue()));
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        MySQLComm comm = MySQLComm.getInstance();
        ResultSet rs = comm.sqlExecuteQuery("select * from user;");
        try {
            while (rs.next()) {
                User user = new User(
                        new UserId(rs.getString("id")),
                        new UserName(rs.getString("name")),
                        new UserPassword(rs.getString("password"))
                );
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public Optional<User> find(String userId) {
        MySQLComm comm = MySQLComm.getInstance();
        ResultSet rs = comm.sqlExecuteQuery(String.format("select * from user where id = %s;", userId));
        User user = null;
        try {
            user = new User(
                    new UserId(rs.getString("id")),
                    new UserName(rs.getString("name")),
                    new UserPassword(rs.getString("password"))
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(user);
    }

}
