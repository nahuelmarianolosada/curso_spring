package com.incluit.springapp.web.model.dao;

import com.incluit.springapp.web.model.domain.StudentEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by nlosada on 24/05/18.
 */
@Repository("StudentDao")
public class StudentDaoImpl implements IStudentDao {

    @Autowired
    SessionFactory sessionFactory;

    public List<StudentEntity> getAll() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(StudentEntity.class);
        return criteria.list();
    }

    public StudentEntity get(int studentId) {
        StudentEntity o = (StudentEntity)sessionFactory.
                getCurrentSession().
                get(StudentEntity.class, studentId);
        return o;
    }


    @Override
    public List<StudentEntity> getAllSignedToCourse(int idCourse) {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("getStudentsByCourse").setInteger("idCourse", idCourse)
                .list();
    }

    public void insert(StudentEntity studentEntity) {
     /*   sessionFactory.getCurrentSession().save(studentEntity);
     */
     Session session = this.sessionFactory.getCurrentSession();
        session.save(studentEntity);
    }


    public void update(StudentEntity studentEntity) {
        sessionFactory.getCurrentSession().update(studentEntity);
    }


    public void delete(int studentId) {
        StudentEntity studentEntityToDelete = get(studentId);
        sessionFactory.getCurrentSession().delete(studentEntityToDelete);
    }


}
