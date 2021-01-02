package jp.ac.shibaura.it.ie.config;

import java.util.HashMap;
import java.util.Map;

public class Config {
  private final static Config config = new Config();

  private Map<String, String> store = new HashMap<>();

  public static Config get() {
    return config;
  }

  public Config() {
    store.put("DBURL", System.getenv("DB_URL") != null ? System.getenv("DB_URL") : "");
    store.put("DBPort", System.getenv("DB_PORT") != null ? System.getenv("DB_PORT") : "");
    store.put("DBName", System.getenv("DB_NAME") != null ? System.getenv("DB_NAME") : "");
    store.put("DBUserId", System.getenv("DB_USER_ID") != null ? System.getenv("DB_USER_ID") : "");
    store.put("DBPassword", System.getenv("DB_PASSWORD") != null ? System.getenv("DB_PASSWORD") : "");
    store.put("ClientId", System.getenv("CLIENT_ID") != null ? System.getenv("CLIENT_ID") : "");
  }

  public String getDBUrl() {
    return store.get("DBURL");
  }
  public String getDBPort() {
    return store.get("DBPort");
  }
  public String getDBName() {
    return store.get("DBName");
  }
  public String getDBUserId() {
    return store.get("DBUserId");
  }
  public String getDBPassword() {
    return store.get("DBPassword");
  }
  public String getClientId() {
    return store.get("ClientId");
  }
}