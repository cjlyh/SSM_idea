package com.lyh.service;

import com.github.pagehelper.PageInfo;
import com.lyh.domain.Resource;
import com.lyh.domain.ResourceVo;

import java.util.List;

public interface ResourceService {

    /*
        资源分页以及多条件查询
     */

    public PageInfo<Resource> findAllResourceByPage(ResourceVo resourceVo);

}
