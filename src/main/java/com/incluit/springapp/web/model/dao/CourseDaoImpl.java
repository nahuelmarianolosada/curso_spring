package com.incluit.springapp.web.model.dao;

import com.incluit.springapp.web.model.domain.CourseEntity;
import com.incluit.springapp.web.model.domain.StudentEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 12/06/18.
 */

@Repository("CourseDao")
public class CourseDaoImpl implements ICourseDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CourseEntity> getAll() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(CourseEntity.class);
        return criteria.list();
    }



    @Override
    public CourseEntity get(int courseId) {
        CourseEntity o = (CourseEntity)sessionFactory.
                getCurrentSession().
                get(CourseEntity.class, courseId);
        return o;
    }


    @Override
    public List<CourseEntity> getCoursesByProfessor(int idProfessor) {
        return sessionFactory.getCurrentSession()
                .getNamedQuery("getCoursesByProfessor").setInteger("idProfessor", idProfessor)
                .list();
    }


    @Override
    public void insert(CourseEntity courseEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(courseEntity);
    }

    @Override
    public void delete(int courseId) {
        CourseEntity courseEntity = get(courseId);
        sessionFactory.getCurrentSession().delete(courseEntity);
    }

    @Override
    public void update(CourseEntity courseEntity) {
        sessionFactory.getCurrentSession().update(courseEntity);
    }
}
