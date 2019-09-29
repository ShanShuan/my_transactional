package com.shanshuan.ruiphone.my_transactional.service;

import com.shanshuan.ruiphone.my_transactional.anonation.MyTransaction;
import com.shanshuan.ruiphone.my_transactional.manager.MyJdbcManager;
import com.shanshuan.ruiphone.my_transactional.utils.MyJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by wangzifeng on 2019/9/29.
 */
@Service
public class TestService {
    @Autowired
    MyJdbcManager myJdbcManager;


    @MyTransaction
    public void execute(String sql) throws SQLException {
        myJdbcManager.execute(sql);
        int i=1/0;
    }
}
