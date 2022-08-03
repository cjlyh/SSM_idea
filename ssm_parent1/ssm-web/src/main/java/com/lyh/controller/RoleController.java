package com.lyh.controller;

import com.lyh.domain.*;
import com.lyh.service.MenuService;
import com.lyh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    /*
        根据条件进行查询所有角色
     */

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){

        List<Role> allRole = roleService.findAllRole(role);

        return new ResponseResult(true,200,"查询所有角色成功",allRole);

    }

    /*
        查询所有的父子菜单信息(分配菜单的第一个接口)
     */
    @RequestMapping("/findAllMenu")
    public ResponseResult findSubMenuListByPid(){

        // -1 表示查询所有的父级菜单(包括子级菜单)
        List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);

        Map<String, Object> map = new HashMap<>();

        map.put("parentMenuList",subMenuListByPid);

        return new ResponseResult(true,200,"查询菜单成功",map);

    }

    /*
        根据角色ID查询该角色关联的菜单信息ID [1,2,3,4,5]
     */
    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId(Integer roleId){
        return new ResponseResult(true,200,"查询成功",roleService.findMenuByRoleId(roleId));
    }

    /*
        为角色分配菜单信息
     */
    @RequestMapping("/RoleContextMenu")
    public ResponseResult roleContextMenu(@RequestBody RoleMenuVo roleMenuVo){

        roleService.roleContextMenu(roleMenuVo);
        return new ResponseResult(true,200,"响应成功",null);
    }

    /*
        删除角色
     */
    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){

        roleService.deleteRole(id);

        return new ResponseResult(true,200,"删除角色成功",null);

    }

}
