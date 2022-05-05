package ind.milo.dao;

import ind.milo.entity.Work;
import ind.milo.util.SessionUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WorkDao {
     private Connection connection = SessionUtil.getConnection();

     public Work getWorkById(){
         return null;
     }

     public List<Work> listWork(){
         String sql = "select * from tbwork";
         Statement statement = null;
         ResultSet resultSet = null;
         ArrayList<Work> works = new ArrayList<>();
         try {
             statement = connection.createStatement();
             resultSet = statement.executeQuery(sql);

             while (resultSet.next()) {
                 Work work = new Work();
                 work.setMdfNo(resultSet.getString("mdf_no"));
                 work.setMdfReason(resultSet.getString("mdf_reason"));
                 work.setMdfDetail(resultSet.getString("mdf_detail"));
                 work.setVersion(resultSet.getString("version"));
                 work.setRequireNo(resultSet.getString("require_no"));
                 work.setCreateDate(resultSet.getDate("create_date"));
                 works.add(work);
             }


         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             if (resultSet != null) {
                 try {
                     resultSet.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
             if (statement != null) {
                 try {
                     statement.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
             }
         }

         return works;
     }

    public static void main(String[] args) {
        WorkDao workDao = new WorkDao();
        List<Work> works = workDao.listWork();
        System.out.println(works);
    }
}
