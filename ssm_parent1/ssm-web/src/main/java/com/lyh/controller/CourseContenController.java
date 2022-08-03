package com.lyh.controller;

import com.lyh.domain.Course;
import com.lyh.domain.CourseLesson;
import com.lyh.domain.CourseSection;
import com.lyh.domain.ResponseResult;
import com.lyh.service.CourseContenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("courseContent")
public class CourseContenController {

    @Autowired
    private CourseContenService courseContenService;

    /*
        查询课程内容(章节+课时)
     */
    @RequestMapping("/findSectionAndLesson")
    public ResponseResult findSectionAndLessonByCourseId(Integer courseId){

        //调用Service
        List<CourseSection> list = courseContenService.findSectionAndLessonByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true, 200, "章节及课时查询成功", list);
        return responseResult;

    }

    /*
        回显章节对应的课程信息
     */
    @RequestMapping("/findCourseByCourseId")
    public ResponseResult findCouserByCouserId(Integer courseId){
        Course couser = courseContenService.findCouserByCourseId(courseId);

        ResponseResult responseResult = new ResponseResult(true, 200, "查询课程信息成功", couser);
        return responseResult;

    }

    /*
        新增&更新章节信息
     */
    @RequestMapping("/saveOrUpdateSection")
    public ResponseResult saveOrUpdateSection(@RequestBody CourseSection courseSection){

        //判断是否携带了章节ID
        if (courseSection.getId() ==null){
            //新增
            courseContenService.saveSection(courseSection);
            ResponseResult responseResult = new ResponseResult(true, 200, "章节信息新建成功", null);
            return responseResult;
        }else{
            //更新操作
            courseContenService.updateSection(courseSection);
            ResponseResult responseResult = new ResponseResult(true, 200, "章节信息更新成功", null);
            return responseResult;
        }
    }

    /*
        更新章节状态
     */
    @RequestMapping("updateSectionStatus")
    public ResponseResult updateSectionStatus(Integer id,Integer status){
        courseContenService.updateSectionStatus(id,status);
        Map<String, Object> map = new HashMap<>();
        map.put("status",status);
        ResponseResult responseResult = new ResponseResult(true, 200, "修改章节状态成功", map);
        return responseResult;
    }

    /*
        新增&更新课时信息
     */
    @RequestMapping("saveOrUpdateLesson")
    public ResponseResult saveOrUpdateLesson(@RequestBody CourseLesson courseLesson){
        courseContenService.saveLesson(courseLesson);
        return new ResponseResult(true,200,"新增课时信息",null);
    }


}
