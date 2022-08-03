package com.lyh.service.impl;

import com.lyh.dao.ResourceCategoryMapper;
import com.lyh.domain.ResourceCategory;
import com.lyh.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceCategoryServiceImpl implements ResourceCategoryService {

    @Autowired
    private ResourceCategoryMapper resourceCategoryMapper;

    @Override
    public List<ResourceCategory> findAllResourceCategory() {

        return resourceCategoryMapper.findAllResourceCategory();
    }
}
