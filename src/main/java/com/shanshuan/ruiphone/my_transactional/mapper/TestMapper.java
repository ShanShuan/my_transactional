package com.shanshuan.ruiphone.my_transactional.mapper;

import com.shanshuan.ruiphone.my_transactional.model.Test;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by wangzifeng on 2019/9/27.
 */
@Mapper
public interface TestMapper {
    public void insert(Test one);
}
