package com.lyh.dao;

import com.lyh.domain.Menu;

import java.util.List;

public interface MenuMapper {

    /*
        查询所有父子菜单信息
     */

    public List<Menu> findSubMenuListByPid(int pid);

    /*
        查询所有菜单列表
     */

    public List<Menu> findAllMenu();


    /*
        根据Id查询Menu
     */
    public Menu findMenuById(Integer id);
}
