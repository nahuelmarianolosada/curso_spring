package com.incluit.springapp.web.service;

import com.incluit.springapp.web.model.dao.IProfessorDao;
import com.incluit.springapp.web.model.domain.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by nlosada on 13/06/18.
 */

@Transactional
@Service
public class ProfessorService implements IProfessorService {

    @Autowired
    IProfessorDao dao;

    @Override
    public List<ProfessorEntity> getAll() {
        return dao.getAll();
    }

    @Override
    public ProfessorEntity getById(int idProfessor) {
        return dao.get(idProfessor);
    }

    @Override
    public void insert(ProfessorEntity professorEntity) {
        dao.insert(professorEntity);
    }

    @Override
    public void update(ProfessorEntity professorEntity) {
        dao.update(professorEntity);
    }

    @Override
    public void delete(int professorId) {
        dao.delete(professorId);
    }
}
