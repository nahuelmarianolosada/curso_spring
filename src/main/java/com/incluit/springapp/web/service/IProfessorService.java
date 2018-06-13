package com.incluit.springapp.web.service;

import com.incluit.springapp.web.model.domain.ProfessorEntity;

import java.util.List;

/**
 * Created by nlosada on 13/06/18.
 */
public interface IProfessorService {

    List<ProfessorEntity> getAll();

    ProfessorEntity getById(int idProfessor);

    void insert(ProfessorEntity professorEntity);

    void update(ProfessorEntity professorEntity);

    void delete(int professorId);

}
