package com.incluit.springapp.web.model.dao;

import com.incluit.springapp.web.model.domain.CourseEntity;

import java.util.List;

/**
 * Created by nlosada on 12/06/18.
 */
public interface ICourseDao {

    List<CourseEntity> getAll();
    CourseEntity get(int courseId);
    List<CourseEntity> getCoursesByProfessor(int idProfessor);
    void insert(CourseEntity courseEntity);
    void delete(int studentId);
    void update(CourseEntity courseEntity);
}
