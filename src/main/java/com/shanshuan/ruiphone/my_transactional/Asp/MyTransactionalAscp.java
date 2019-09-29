package com.shanshuan.ruiphone.my_transactional.Asp;

import com.shanshuan.ruiphone.my_transactional.anonation.MyTransaction;
import com.shanshuan.ruiphone.my_transactional.utils.MyJdbcTemplate;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by wangzifeng on 2019/9/27.
 */
@Component
@Aspect
public class MyTransactionalAscp {
//    @Before()
//    @After()
    @Autowired
    MyJdbcTemplate myJdbcTemplate;


    @Around("@annotation(myTransaction)")
    public Object mytest(ProceedingJoinPoint point, MyTransaction myTransaction) throws SQLException {
        Connection connection = myJdbcTemplate.getConnection();
        try {
            connection.setAutoCommit(false);
            Object proceed = point.proceed();
            connection.commit();
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            connection.rollback();
        }finally {
            if(connection!=null)
            connection.close();
        }
        return null;
    }
}
