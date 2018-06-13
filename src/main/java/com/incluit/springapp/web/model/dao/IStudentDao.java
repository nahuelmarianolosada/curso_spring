package com.incluit.springapp.web.model.dao;

import com.incluit.springapp.web.model.domain.StudentEntity;

import java.util.List;

/**
 * Created by nlosada on 24/05/18.
 */
public interface IStudentDao {
    List<StudentEntity> getAll();
    StudentEntity get(int studentId);
    public List<StudentEntity> getAllSignedToCourse(int idCourse);
    void insert(StudentEntity studentEntity);
    void delete(int studentId);
    void update(StudentEntity studentEntity);

}
