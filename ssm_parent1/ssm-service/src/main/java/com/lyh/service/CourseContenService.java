package com.lyh.service;

import com.lyh.domain.Course;
import com.lyh.domain.CourseLesson;
import com.lyh.domain.CourseSection;

import java.util.List;

public interface CourseContenService {
    /*
        根据课程id查询对应的课程内容(章节+课时)
     */

    public List<CourseSection> findSectionAndLessonByCourseId(Integer id);

    /*
        回显章节对应的课程信息
     */

    public Course findCouserByCourseId(Integer courseId);

    /*
        新增章节信息
     */
    public void saveSection(CourseSection courseSection);

    /*
        更新章节信息
     */
    public void updateSection(CourseSection courseSection);

    /*
        更新章节状态
     */
    public void updateSectionStatus(Integer id,Integer status);

    /*
        新增课时信息
     */
    public void  saveLesson(CourseLesson courseLesson);
}
