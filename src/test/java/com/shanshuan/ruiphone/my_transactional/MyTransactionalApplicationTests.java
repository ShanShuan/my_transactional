package com.shanshuan.ruiphone.my_transactional;

import com.shanshuan.ruiphone.my_transactional.Asp.MyTransactionalAscp;
import com.shanshuan.ruiphone.my_transactional.anonation.MyTransaction;
import com.shanshuan.ruiphone.my_transactional.manager.MyJdbcManager;
import com.shanshuan.ruiphone.my_transactional.mapper.TestMapper;
import com.shanshuan.ruiphone.my_transactional.service.TestService;
import com.shanshuan.ruiphone.my_transactional.utils.MyJdbcTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAspectJAutoProxy
public class MyTransactionalApplicationTests {

    @Autowired
    TestMapper testMapper;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    public void test01() {
        testMapper.insert(new com.shanshuan.ruiphone.my_transactional.model.Test("哈哈"));
       int a= 1/0;
    }


    @Test
    public void test02() {
        jdbcTemplate.execute( "insert into test (name ) values(\"喜喜\")");
        int a= 1/0;
    }

    @Test
    public void test03() {
        Connection connection=null;
        try {
             connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            statement.execute("insert into test (name ) values(\"呵呵\")");
            int a= 1/0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection!=null)connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Autowired
    MyJdbcTemplate myJdbcTemplate;

//    @Test
//    public void test04() {
//        myJdbcTemplate.execute( "insert into test (name ) values(\"吱吱\")");
//    }
    @Autowired
    MyJdbcManager myJdbcManager;

    @Autowired
    TestService testService;

    @Test
    public void test05() throws SQLException {
        testService.execute( "insert into test (name ) values(\"吱吱\")");
    }
}
