package com.lyh.dao;

import com.lyh.domain.Course;
import com.lyh.domain.CourseLesson;
import com.lyh.domain.CourseSection;

import java.util.List;

public interface CourseContenMapper {
    /*
        根据课程ID查询关联的章节信息及章节信息关联的课时信息
     */
    public List<CourseSection> findSectionAndLessonByCourseId(Integer CourseId);

    /*
        回显章节对应的课程信息
     */
    public Course findCouserByCourseId(Integer courseId);

    /*
        保存章节信息
     */
    public void saveSection(CourseSection courseSection);

    /*
        更新章节信息
     */
    public void updateSection(CourseSection courseSection);

    /*
        更新章节状态
     */
    public void updateSectionStatus(CourseSection courseSection);

    /*
        新增课时信息
     */
    public void saveLesson(CourseLesson courseLesson);
}
