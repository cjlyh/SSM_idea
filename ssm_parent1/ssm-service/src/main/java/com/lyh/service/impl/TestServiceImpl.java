package com.lyh.service.impl;

import com.lyh.dao.TestMapper;
import com.lyh.domain.Test;
import com.lyh.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {

        List<Test> allTest = testMapper.findAllTest();
        return allTest;
    }
}
