package ind.milo.dao;

import ind.milo.entity.Work;
import ind.milo.util.SessionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkDao {
     private Connection connection = SessionUtil.getConnection();
    private String mdfNo;
    private String mdfReason;
    private String mdfDesc;
    private String version;
    private String requireNo;
    private Date deadline;
    private String tagId;
    private String filePath;

    public int saveOrUpdateWord(Work work) {
        String sql = "";

        return 0;
    }

     public Work getWorkById(String mdfNo){
         String sql = "select * from tbwork where mdf_no=?";
         PreparedStatement preparedStatement = null;
         Statement statement = null;
         ResultSet resultSet = null;

         try {
             preparedStatement  = connection.prepareStatement(sql);
             preparedStatement.setString(1, mdfNo);
             resultSet = preparedStatement.executeQuery(sql);

             Work work = new Work();
             work.setMdfNo(resultSet.getString("mdf_no"));
             work.setMdfReason(resultSet.getString("mdf_reason"));
             work.setMdfDesc(resultSet.getString("mdf_detail"));
             work.setVersion(resultSet.getString("version"));
             work.setRequireNo(resultSet.getString("require_no"));
             work.setDeadline(resultSet.getDate("create_date"));

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
                 work.setMdfDesc(resultSet.getString("mdf_detail"));
                 work.setVersion(resultSet.getString("version"));
                 work.setRequireNo(resultSet.getString("require_no"));
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
