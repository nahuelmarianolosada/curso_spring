package com.incluit.springapp.web.service;

import com.incluit.springapp.web.model.dao.IStudentDao;
import com.incluit.springapp.web.model.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 24/05/18.
 */

@Transactional
@Service
public class StudentService implements IStudentService {


    @Autowired
    IStudentDao dao;


    public List<StudentEntity> getAll() {
        return dao.getAll();
    }


    public StudentEntity getById(int idStudent) {
        return dao.get(idStudent);
    }

    public List<StudentEntity> getAllSignedToCourse(int idCourse){
        return dao.getAllSignedToCourse(idCourse);
    }

    @Transactional
    public void insert(StudentEntity studentEntity) {
        dao.insert(studentEntity);
    }

    @Transactional
    public void update(StudentEntity studentEntity) {
        dao.update(studentEntity);
    }

    @Transactional
    public void delete(int studentEntity) {
        dao.delete(studentEntity);
    }
}
