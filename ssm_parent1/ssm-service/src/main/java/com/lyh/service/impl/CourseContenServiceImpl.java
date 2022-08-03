package com.lyh.service.impl;

import com.lyh.dao.CourseContenMapper;
import com.lyh.domain.Course;
import com.lyh.domain.CourseLesson;
import com.lyh.domain.CourseSection;
import com.lyh.service.CourseContenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseContenServiceImpl implements CourseContenService {

    @Autowired
    private CourseContenMapper courseContenMapper;

    @Override
    public List<CourseSection> findSectionAndLessonByCourseId(Integer id) {

        List<CourseSection> list = courseContenMapper.findSectionAndLessonByCourseId(id);
        return list;
    }

    @Override
    public Course findCouserByCourseId(Integer courseId) {

        Course couserByCourseId = courseContenMapper.findCouserByCourseId(courseId);
        return couserByCourseId;
    }

    @Override
    public void saveSection(CourseSection courseSection) {
        //1.补全信息
        Date date = new Date();
        courseSection.setCreateTime(date);
        courseSection.setUpdateTime(date);

        //2.调用mapper方法
        courseContenMapper.saveSection(courseSection);

    }

    @Override
    public void updateSection(CourseSection courseSection) {

        //1.补全信息
        courseSection.setUpdateTime(new Date());

        //2.调用mapper方法
        courseContenMapper.updateSection(courseSection);
    }

    @Override
    public void updateSectionStatus(Integer id,Integer status) {
        CourseSection courseSection = new CourseSection();
        courseSection.setId(id);
        courseSection.setStatus(status);
        courseSection.setUpdateTime(new Date());
        courseContenMapper.updateSectionStatus(courseSection);
    }

    @Override
    public void saveLesson(CourseLesson courseLesson) {
        Date date = new Date();
        courseLesson.setCreateTime(date);
        courseLesson.setUpdateTime(date);

        courseContenMapper.saveLesson(courseLesson);
    }
}
