package com.shanshuan.ruiphone.my_transactional.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wangzifeng on 2019/9/27.
 */
@Component
public class MyJdbcTemplate {
    @Autowired
    DataSource dataSource;
   static ThreadLocal<Connection> connectionThreadLocal=new ThreadLocal<>();


   public Connection  getConnection(){
       Connection connection=null;
       try {
           connection=connectionThreadLocal.get();
           if(connection==null)
           {
               connection = dataSource.getConnection();
               connectionThreadLocal.set(connection);
           }

       }catch (Exception e){
           e.printStackTrace();
       }
       return connection;
   }



//    public  void execute(String sql){
//        Connection connection=null;
//        try {
//            connection=connectionThreadLocal.get();
//            if(connection==null)
//            {
//                connection = dataSource.getConnection();
//                connectionThreadLocal.set(connection);
//            }
//            Statement statement = connection.createStatement();
//            statement.execute(sql);
//            int a= 1/0;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if(connection!=null)connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }


//    public  void execute(String sql){
//
//    }



}
