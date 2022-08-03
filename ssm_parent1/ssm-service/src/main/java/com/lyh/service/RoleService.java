package com.lyh.service;

import com.lyh.domain.Role;
import com.lyh.domain.RoleMenuVo;
import com.lyh.domain.Role_menu_relation;

import java.util.List;

public interface RoleService {

    /*
        根据条件查询所有角色
     */

    public List<Role> findAllRole(Role role);

    /*
        根据角色ID查询该角色关联的菜单信息ID [1,2,3,4,5]
     */
    public List<Integer> findMenuByRoleId(Integer roleid);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    /*
        删除角色
     */
    public void deleteRole(Integer roleid);


}
