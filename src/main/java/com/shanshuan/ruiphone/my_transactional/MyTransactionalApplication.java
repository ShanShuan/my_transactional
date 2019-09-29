package com.shanshuan.ruiphone.my_transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(scanBasePackages="com.shanshuan.ruiphone.my_transactional")
@EnableAspectJAutoProxy
public class MyTransactionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyTransactionalApplication.class, args);
    }

}
