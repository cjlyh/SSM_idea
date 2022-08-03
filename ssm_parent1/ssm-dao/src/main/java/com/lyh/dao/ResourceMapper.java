package com.lyh.dao;

import com.lyh.domain.Resource;
import com.lyh.domain.ResourceVo;

import java.util.List;

public interface ResourceMapper {

    /*
        资源分页以及多条件查询
     */

    public List<Resource> findAllResourceByPage(ResourceVo resourceVo);


}
