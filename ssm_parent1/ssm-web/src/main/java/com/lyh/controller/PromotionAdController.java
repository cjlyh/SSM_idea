package com.lyh.controller;

import com.github.pagehelper.PageInfo;
import com.lyh.domain.PromotionAd;
import com.lyh.domain.PromotionAdVo;
import com.lyh.domain.ResponseResult;
import com.lyh.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    /*
        广告分页查询
     */
    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVo promotionAdVo){
        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAdByPage(promotionAdVo);

        return new ResponseResult(true,200,"广告分页查询成功",pageInfo);

    }

    /*
        图片上传
     */
    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        //1.判断上传文件是否为空
        if (file.isEmpty()){
            throw  new RuntimeException();
        }


        //2.获取项目部署路径
        // D:\apache-tomcat-8.5.56\webapps\ssm_web\
        String realPath = request.getServletContext().getRealPath("/");
        // D:\apache-tomcat-8.5.56\webapps\
        String substring = realPath.substring(0, realPath.indexOf("ssm_web"));

        //3.获取原文件名
        //lwx.jpg
        String originalFilename = file.getOriginalFilename();

        //4.生成新文件名,防止重复
        //当前时间戳:2022726.jpg
        String newFileName = System.currentTimeMillis() + originalFilename.substring(originalFilename.lastIndexOf("."));

        //5.文件上传
        // D:\apache-tomcat-8.5.56\webapps\ upload
        String uploadPath = substring + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        //如果目录不存在则创建目录
        if (!filePath.getParentFile().exists()){
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录" + filePath);
        }

        //图片进行了真正的上传
        file.transferTo(filePath);

        //6.将文件名和文件路径返回,进行响应
        Map<String, String> Map = new HashMap<>();
        Map.put("fileName",newFileName);
        //"filePath":"http://localhost:8080/upload/1597112871741.JPG"
        Map.put("filePath","http://localhost:8080/upload/" + newFileName);

        ResponseResult responseResult = new ResponseResult(true, 200, "图片上传成功", Map);

        return responseResult;
    }

    /*
        广告动态上下线
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(Integer id,Integer status){
        promotionAdService.updatePromotionAdStatus(id,status);

        return new ResponseResult(true,200,"广告动态上下线成功",null);

    }

    /*
        新增和修改广告信息
     */
    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){
        if (promotionAd.getId() == null){
            promotionAdService.savePromotionAd(promotionAd);
            return new ResponseResult(true,200,"新增广告信息成功",null);
        }else {
            promotionAdService.updatePromotionAd(promotionAd);
            return new ResponseResult(true,200,"修改广告信息成功",null);
        }
    }

    /*
        根据id回显广告信息
     */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(Integer id){
        PromotionAd list = promotionAdService.findPromotionAdById(id);
        return new ResponseResult(true,200,"回显广告信息成功",list);
    }



}
