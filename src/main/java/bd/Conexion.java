package bd;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConnection() throws SQLException {
        Dotenv dotenv = Dotenv.load();
        String url = "jdbc:sqlserver://" + dotenv.get("DB_SERVER") + ":1433;"
                + "database=" + dotenv.get("DB_NAME") + ";"
                + "user=" + dotenv.get("DB_USER") + ";"
                + "password=" + dotenv.get("DB_PASSWORD") + ";"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
        return DriverManager.getConnection(url);
    }
}
