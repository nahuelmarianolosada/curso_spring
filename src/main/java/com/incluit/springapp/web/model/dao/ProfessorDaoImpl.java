package com.incluit.springapp.web.model.dao;

import com.incluit.springapp.web.model.domain.ProfessorEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nlosada on 13/06/18.
 */
@Repository
public class ProfessorDaoImpl implements IProfessorDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<ProfessorEntity> getAll() {
        Criteria criteria = sessionFactory.
                getCurrentSession().
                createCriteria(ProfessorEntity.class);
        return criteria.list();
    }



    @Override
    public ProfessorEntity get(int professorId) {
        ProfessorEntity o = (ProfessorEntity)sessionFactory.
                getCurrentSession().
                get(ProfessorEntity.class, professorId);
        return o;
    }

    @Override
    public void insert(ProfessorEntity professorEntity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(professorEntity);
    }

    @Override
    public void delete(int professorId) {
        ProfessorEntity professorEntity = get(professorId);
        sessionFactory.getCurrentSession().delete(professorEntity);
    }

    @Override
    public void update(ProfessorEntity professorEntity) {
        sessionFactory.getCurrentSession().update(professorEntity);
    }
}
