package com.incluit.springapp.web.model.dao;

import com.incluit.springapp.web.model.domain.ProfessorEntity;

import java.util.List;

/**
 * Created by nlosada on 13/06/18.
 */
public interface IProfessorDao {
    List<ProfessorEntity> getAll();
    ProfessorEntity get(int professorId);
    void insert(ProfessorEntity professorEntity);
    void delete(int professorId);
    void update(ProfessorEntity professorEntity);
}
