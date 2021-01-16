package jp.ac.shibaura.it.ie.gateways.databese;

import jp.ac.shibaura.it.ie.config.Config;
import jp.ac.shibaura.it.ie.log.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Component
public class MySQLComm {
    @Autowired
    private LogUtils logger;
    private static MySQLComm mySQLComm = new MySQLComm();
    private Connection conn;

    private MySQLComm() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String target = Config.get().getDBUrl() + ":" + Config.get().getDBPort() + "/" + Config.get().getDBName();
            //conn = DriverManager.getConnection(target, Config.get().getDBUserId(), Config.get().getDBPassword());
            conn = DriverManager.getConnection("jdbc:mysql://sql.yamazaki.se.shibaura-it.ac.jp:13308/db_group_a", "group_a", "group_a");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MySQLComm getInstance() {
        return mySQLComm;
    }

    public Connection getConn(){
        return this.conn;
    }

    public boolean sqlExecuteUpdate(String sql){
        int result = 0;
        try {
            System.out.println(sql);
            Statement st = this.getConn().createStatement();
            result = st.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet sqlExecuteQuery(String sql){
        ResultSet rs = null;
        try {
            Statement st = this.getConn().createStatement();
            rs = st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeDB() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
