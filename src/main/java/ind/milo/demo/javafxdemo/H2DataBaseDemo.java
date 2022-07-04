package ind.milo.demo.javafxdemo;

import java.sql.*;

public class H2DataBaseDemo {
    private static final String JDBC_URL = "jdbc:h2:./database/student";
//    private static final String JDBC_TCP_URL = "jdbc:h2:tcp://127.0.0.1/./database/student";
//    private static final String JDBC_TCP_URL = "jdbc:h2:tcp://127.0.0.1/F:/JavaFX/HSTools/database/student";
    private static final String USER = "test";
    private static final String PASSWORD = "213213";
    private static final String DRIVER_CLASS = "org.h2.Driver";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER_CLASS);
        Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from USER_INF");

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt("id") + ", " + resultSet.getString("name") + ", " + resultSet.getString("sex"));
        }

        statement.close();
        conn.close();
    }
}
