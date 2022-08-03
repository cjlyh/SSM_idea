package com.lyh.dao;

import com.lyh.domain.Test;

import java.util.List;

public interface TestMapper {
    /*
        对test表进行查询所有操作
     */
    public List<Test> findAllTest();
}
