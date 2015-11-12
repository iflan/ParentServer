package wang.ming15.parentserver.core.database;

import wang.ming15.vertx3.core.util.PropertiesConfig;
import wang.ming15.vertx3.core.vertx.Vertxs;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;
import io.vertx.ext.sql.ResultSet;
import io.vertx.ext.sql.SQLConnection;

/**
 *
 * Created by wanggnim on 2015/8/31.
 */
public enum SharedExecutor {

    INSTANCE;

    private JDBCClient client;

    SharedExecutor() {
        Vertx vertx = Vertxs.SHARED_DATA_SOURCE.vertx();
        JsonObject config = getC3P0Config();
        client = JDBCClient.createShared(vertx, config);
    }

    private JsonObject getC3P0Config() {
        JsonObject config = new JsonObject()
                .put("url", "jdbc:mysql://" + PropertiesConfig.JDBC_URL.stringValue())
                .put("driver_class", "com.mysql.jdbc.Driver")
                .put("user", PropertiesConfig.JDBC_USER.stringValue())
                .put("password", PropertiesConfig.JDBC_PASSWORD.stringValue())
                .put("max_pool_size", "20")
                .put("initial_pool_size", "1")
                .put("min_pool_size", "1")
                .put("max_statements", "20000")
                .put("max_statements_per_connection", "200")
                .put("max_idle_time", "10");

        return config;
    }

    public void query(String sql) {
        client.getConnection(event -> {
            if (event.succeeded()) {
                SQLConnection connection = event.result();

                connection.query(sql, res2 -> {
                    if (res2.succeeded()) {
                        ResultSet rs = res2.result();
                    }
                });
            }
        });
    }
}
