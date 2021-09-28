package DBConections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:postgresql://maisonbleue2020.ddns.net";
        String db = "tarea";
        String user = "guest";
        String password = "Tilin123";
        try{
            Class.forName("org.postgresql.Driver");

            conn = DriverManager.getConnection(url + "/" + db, user, password);
            System.out.println("Conexión establecida a PostgreSQL");
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error al abrir Conexión PostgreSQL: " + ex.getMessage());
        }

        return conn;
    }
}