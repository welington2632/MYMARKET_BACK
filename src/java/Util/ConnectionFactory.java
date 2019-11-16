package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConexao() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        //IP:PORT/DBNAME , username, password
        Connection con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/OliveiraTrades", "postgres", "root");
        return con;
    }
}