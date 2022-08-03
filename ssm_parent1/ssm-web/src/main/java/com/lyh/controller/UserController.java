package com.lyh.controller;

import com.github.pagehelper.PageInfo;
import com.lyh.domain.ResponseResult;
import com.lyh.domain.Role;
import com.lyh.domain.User;
import com.lyh.domain.UserVo;
import com.lyh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
        用户分页&多条件组合查询
     */
    @RequestMapping("/findAllUserByPage")
    public ResponseResult findAllUserByPage(@RequestBody UserVo userVo){

        PageInfo allUserByPage = userService.findAllUserByPage(userVo);

        return new ResponseResult(true,200,"用户分页&多条件组合查询成功",allUserByPage);

    }

    /*
        用户状态设置
     */
    @RequestMapping("/updateUserStatus")
    public ResponseResult updateUserStatus(Integer id,String status){
        userService.updateUserStatus(id,status);

        return new ResponseResult(true,200,"用户状态设置成功",status);

    }

    /*
        用户登录
     */
    @RequestMapping("/login")
    public ResponseResult login(User user, HttpServletRequest request) throws Exception {

        User user1 = userService.login(user);

        if (user1 != null){

            //保存用户id及access_token到session中
            HttpSession session = request.getSession();
            String access_token = UUID.randomUUID().toString();
            session.setAttribute("access_token",access_token);
            session.setAttribute("user_id",user1.getId());

            //将查询出来的信息响应给前台
            Map<String, Object> map = new HashMap<>();
            map.put("access_token",access_token);
            map.put("user_id",user1.getId());

            //将查询出来的user也存到map中
            map.put("user",user1);

            return new ResponseResult(true,1,"登录成功",map);

        }else {
            return new ResponseResult(true,400,"用户名密码错误",null);
        }
    }

    /*
        分配角色(回显)
     */
    @RequestMapping("/findUserRoleById")
    public ResponseResult findUserRelationRoleById(Integer id){

        return new ResponseResult(true,200,"响应成功",userService.findUserRelationRoleById(id));
    }

    /*
        分配角色
     */
    @RequestMapping("/userContextRole")
    public ResponseResult userContextRole(@RequestBody UserVo userVo){
        userService.userContextRole(userVo);
        return new ResponseResult(true,200,"分配角色成功",null);
    }

    /*
        获取用户权限进行菜单动态展示
     */
    @RequestMapping("/getUserPermissions")
    public ResponseResult getUserPermissions(HttpServletRequest request){

        //1.获取请求头中的token
        String header_token = request.getHeader("access_token");
        HttpSession session = request.getSession();
        //2.获取session中的token
        String access_token = (String) session.getAttribute("access_token");
        //3.判断token是否一致
        if (header_token.equalsIgnoreCase(access_token)){
            //获取用户id
            Integer user_id = (Integer) session.getAttribute("user_id");
            ResponseResult responseResult = userService.getUserPermissios(user_id);
            return responseResult;
        }else {
            return new ResponseResult(false,400,"获取失败",null);
        }


    }


}
