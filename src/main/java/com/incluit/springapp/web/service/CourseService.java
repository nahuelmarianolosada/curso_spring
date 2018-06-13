package com.incluit.springapp.web.service;

import com.incluit.springapp.web.model.dao.ICourseDao;
import com.incluit.springapp.web.model.domain.CourseEntity;
import com.incluit.springapp.web.model.domain.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 12/06/18.
 */


@Transactional
@Service
public class CourseService implements ICourseService{

    @Autowired
    ICourseDao dao;


    @Override
    public List<CourseEntity> getAll() {
        return dao.getAll();
    }


    @Override
    public CourseEntity getById(int courseId) {
        return dao.get(courseId);
    }


    @Override
    public List<CourseEntity> getByProfessorId(int idProfessor){return dao.getCoursesByProfessor(idProfessor);}

    @Override
    @Transactional
    public void insert(CourseEntity courseEntity) {
        dao.insert(courseEntity);
    }

    @Override
    @Transactional
    public void update(CourseEntity courseEntity) {
        dao.update(courseEntity);
    }

    @Override
    @Transactional
    public void delete(int courseId) {
        dao.delete(courseId);
    }
}
