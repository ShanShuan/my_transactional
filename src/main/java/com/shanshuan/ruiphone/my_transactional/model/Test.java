package com.shanshuan.ruiphone.my_transactional.model;

import lombok.Data;

/**
 * Created by wangzifeng on 2019/9/27.
 */
@Data
public class Test {
    private Integer id;
    private String name;

    public Test(String name) {
        this.name = name;
    }
}
