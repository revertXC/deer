package com.deer.mapper;

import com.deer.model.Test;

public interface TestMapper {
    int insert(Test record);

    int insertSelective(Test record);
}