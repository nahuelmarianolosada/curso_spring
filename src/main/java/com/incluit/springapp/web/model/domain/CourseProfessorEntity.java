package com.incluit.springapp.web.model.domain;

import javax.persistence.*;

/**
 * Created by nlosada on 30/05/18.
 */
@Entity
@Table(name = "COURSE_PROFESSOR", schema = "school_schema", catalog = "")
public class CourseProfessorEntity {
    private int id;
    private Integer idCourse;
    private Integer idProfessor;
 /*   private CourseEntity courseByIdCourse;
    private ProfessorEntity professorByIdProfessor;*/

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_course", nullable = true, insertable = false, updatable = false)
    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "id_professor", nullable = true, insertable = false, updatable = false)
    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseProfessorEntity that = (CourseProfessorEntity) o;

        if (id != that.id) return false;
        if (idCourse != null ? !idCourse.equals(that.idCourse) : that.idCourse != null) return false;
        if (idProfessor != null ? !idProfessor.equals(that.idProfessor) : that.idProfessor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idCourse != null ? idCourse.hashCode() : 0);
        result = 31 * result + (idProfessor != null ? idProfessor.hashCode() : 0);
        return result;
    }

    /*@ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id")
    public CourseEntity getCourseByIdCourse() {
        return courseByIdCourse;
    }

    public void setCourseByIdCourse(CourseEntity courseByIdCourse) {
        this.courseByIdCourse = courseByIdCourse;
    }

    @ManyToOne
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    public ProfessorEntity getProfessorByIdProfessor() {
        return professorByIdProfessor;
    }

    public void setProfessorByIdProfessor(ProfessorEntity professorByIdProfessor) {
        this.professorByIdProfessor = professorByIdProfessor;
    }*/
}
