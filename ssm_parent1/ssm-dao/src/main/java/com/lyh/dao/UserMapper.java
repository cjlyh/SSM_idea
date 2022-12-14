package com.lyh.dao;

import com.lyh.domain.*;

import java.util.List;

public interface UserMapper {

    /*
        用户分页&多条件组合查询
     */
    public List<User> findAllUserByPage(UserVo userVo);

    /*
        用户状态设置
     */
    public void updateUserStatus(User user);

    /*
        用户登录(根据用户名查询具体的用户信息)
     */
    public User login(User user);



    /*
        根据用户ID清空中间表
     */
    public void deleteUserContextRole(Integer userId);

    /*
        分配角色
     */
    public void userContextRole(User_Role_relation user_role_relation);

    /*
        1.根据用户ID查询关联的角色信息
     */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
        2.根据角色ID查询角色所拥有的顶级菜单(父级菜单)(id=-1)
     */
    public List<Menu> findParentMenuByRoleId(List<Integer> list);

    /*
        3.根据PID,查询子菜单信息
     */
    public List<Menu> findSubMenuByPid(Integer pid);

    /*
        4.获取用户拥有的资源权限信息
     */
    public List<Resource> findResourceByRoleId(List<Integer> list);
    
    public void add();
    
    public void git();
    public void git2();
    public void git3();
    public void git4();
    public void git5();
    public void git6();
    public void git7();
    public void git8();

    public void text();
    public void text2();
    public void text3();
    public void text4();
    public void text5();
    public void text6();
    public void text7();
    public void text8();

}
