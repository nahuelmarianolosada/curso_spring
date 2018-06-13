package com.incluit.springapp.web.service;

import com.incluit.springapp.web.model.domain.StudentEntity;

import java.util.List;

/**
 * Created by nlosada on 24/05/18.
 */
public interface IStudentService {
    List<StudentEntity> getAll();

    StudentEntity getById(int idStudent);

    List<StudentEntity> getAllSignedToCourse(int idCourse);

    void insert(StudentEntity studentEntity);

    void update(StudentEntity studentEntity);

    void delete(int studentId);
}
