package com.lyh.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyh.dao.UserMapper;
import com.lyh.domain.*;
import com.lyh.service.UserService;
import com.lyh.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());

        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);

        PageInfo<User> userPageInfo = new PageInfo<>(allUserByPage);

        return userPageInfo;
    }

    @Override
    public void updateUserStatus(Integer id, String status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        user.setUpdate_time(new Date());

        userMapper.updateUserStatus(user);

    }

    /*
        用户登录
     */
    @Override
    public User login(User user) throws Exception {

        //1.调用mapper方法 user1:包含了密文密码
        User user1 = userMapper.login(user);
        if (user1 != null && Md5.verify(user.getPassword(),"lyh",user1.getPassword())){
            return user1;
        }else {
            return null;
        }

    }

    /*
        分配角色(回显)
     */
    @Override
    public List<Role> findUserRelationRoleById(Integer id) {

        List<Role> list = userMapper.findUserRelationRoleById(id);

        return list;
    }

    /*
        用户关联角色
     */
    @Override
    public void userContextRole(UserVo userVo) {

        //1.根据用户ID清空中间表关联关系
        userMapper.deleteUserContextRole(userVo.getUserId());

        //2.再从新建立关联关系
        for (Integer roleId : userVo.getRoleIdList()) {

            //封装数据
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleId);

            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");

            userMapper.userContextRole(user_role_relation);

        }

    }

    /*
        获取用户权限信息
     */
    @Override
    public ResponseResult getUserPermissios(Integer userid) {

        //1.获取当前用户拥有的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userid);

        //2.获取角色id保存到List中
        ArrayList<Integer> roleIds = new ArrayList<>();

        for (Role role : roleList) {
            roleIds.add(role.getId());
        }

        //3.根据角色ID查询父菜单
        List<Menu> parentList = userMapper.findParentMenuByRoleId(roleIds);

        //4.查询封装父菜单关联的子菜单
        for (Menu menu : parentList) {
            List<Menu> subMenuByPid = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenuByPid);
        }

        //5.获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        //6.封装数据并返回
        Map<String, Object> map = new HashMap<>();
        map.put("menuList",parentList);
        map.put("resourceList",resourceList);


        return new ResponseResult(true,200,"获取用户权限信息成功",map);
    }
}
