package com.lyh.service;

import com.lyh.domain.Course;
import com.lyh.domain.CourseVo;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CourseService {

    /*
        多条件课程列表查询
     */

    public List<Course> findCourseByCondition(CourseVo courseVo);

    /*
        新增课程和讲师信息
     */
    public void saveCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /*
        根据ID查询课程信息
     */

    public CourseVo findCouserById(Integer id);

    /*
        修改课程信息
     */
    public void updateCourseOrTeacher(CourseVo courseVo) throws InvocationTargetException, IllegalAccessException;

    /*
        修改课程状态
     */
    public void updateCourseStatus(int courseid,int status);

}
