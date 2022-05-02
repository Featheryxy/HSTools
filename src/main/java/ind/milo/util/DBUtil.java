package ind.milo.util;

import ind.milo.entity.ToDo;

import java.sql.*;

/**
 * @Date 2022/4/12 22:50
 * @Created by Milo
 */
public class DBUtil {
    private DBUtil(){}

    private static final String USER = "sa";
    private static final String PASSWORD = "213213";
    private static final String DRIVER_CLASS = "org.h2.Driver";
    private static final String JDBC_URL = "jdbc:h2:./database/student";
    private static final String JDBC_TCP_URL = "jdbc:h2:tcp://127.0.0.1/D:/H2/bin/tools";

    // todo 改成单例模式
    public static Connection getConnection(String jdbcTcpUrl, String user, String password){
        try {
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(JDBC_TCP_URL, USER, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection(JDBC_TCP_URL, USER, PASSWORD);
        String metaSql = "select COLUMN_NAME from INFORMATION_SCHEMA.COLUMNS where table_name = 'TODO'";
        PreparedStatement preparedStatement2 = connection.prepareStatement(metaSql);

        String sql = "select * from todo";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ToDo toDo = new ToDo();
        while (resultSet.next()) {
            ResultSetMetaData metaData = resultSet.getMetaData();

            for ( int i = 1 ; i <= metaData.getColumnCount() ; i++ ) {
                toDo.setTodoId(resultSet.getInt("todo_id"));
                toDo.setTodoName(resultSet.getString("todo_name"));
                toDo.setDeadline(resultSet.getInt("deadline"));
                toDo.setMdfTime(resultSet.getString("mdf_time"));
                toDo.setTodoDesc(resultSet.getString("todo_desc"));
                toDo.setComplete(resultSet.getString("complete"));
            }
        }
        System.out.println(toDo);

    }

    public static  <T> T getObject(Class<T> clz) {
        Object obj = null;

        try {
            obj = clz.newInstance();
        } catch (Exception var4) {
        }

        return (T) obj;
    }

}
