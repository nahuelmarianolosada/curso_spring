package com.incluit.springapp.web.service;

import com.incluit.springapp.web.model.domain.CourseEntity;

import java.util.List;

/**
 * Created by nlosada on 12/06/18.
 */
public interface ICourseService {
    List<CourseEntity> getAll();

    CourseEntity getById(int idCourse);

    List<CourseEntity> getByProfessorId(int idProfessor);

    void insert(CourseEntity courseEntity);

    void update(CourseEntity courseEntity);

    void delete(int courseId);
}
