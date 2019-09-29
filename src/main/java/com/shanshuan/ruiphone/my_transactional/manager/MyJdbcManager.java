package com.shanshuan.ruiphone.my_transactional.manager;

import com.shanshuan.ruiphone.my_transactional.utils.MyJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wangzifeng on 2019/9/27.
 */
@Component
public class MyJdbcManager {
    @Autowired
    MyJdbcTemplate myJdbcTemplate;

    public  void execute(String sql) throws SQLException {
        Connection connection = myJdbcTemplate.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}
