package com.lyh.service;

import com.github.pagehelper.PageInfo;
import com.lyh.domain.ResponseResult;
import com.lyh.domain.Role;
import com.lyh.domain.User;
import com.lyh.domain.UserVo;

import java.util.List;

public interface UserService {

    /*
        用户分页&多条件组合查询
     */
    public PageInfo findAllUserByPage(UserVo userVo);

    /*
        用户状态设置
     */
    public void updateUserStatus(Integer id,String status);

    /*
        用户登录(根据用户名查询具体的用户信息)
     */
    public User login(User user) throws Exception;

    /*
        分配角色(回显)
     */
    public List<Role> findUserRelationRoleById(Integer id);


    /*
        用户关联角色
     */
    public void userContextRole(UserVo userVo);

    /*
        获取用户权限,进行菜单动态展示
     */
    public ResponseResult getUserPermissios(Integer userid);

}
