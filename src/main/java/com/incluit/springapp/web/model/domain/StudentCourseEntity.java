package com.incluit.springapp.web.model.domain;

import javax.persistence.*;

/**
 * Created by nlosada on 30/05/18.
 */
@Entity
@Table(name = "STUDENT_COURSE", schema = "school_schema", catalog = "")
public class StudentCourseEntity {
    private int id;
    private Integer idStudent;
    private Integer idCourse;
    private StudentEntity studentByIdStudent;
    private CourseEntity courseByIdCourse;

    @Id
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_student", nullable = true,insertable = false, updatable = false)
    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "id_course", nullable = true, insertable = false, updatable = false)
    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseEntity that = (StudentCourseEntity) o;

        if (id != that.id) return false;
        if (idStudent != null ? !idStudent.equals(that.idStudent) : that.idStudent != null) return false;
        if (idCourse != null ? !idCourse.equals(that.idCourse) : that.idCourse != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (idStudent != null ? idStudent.hashCode() : 0);
        result = 31 * result + (idCourse != null ? idCourse.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id")
    public StudentEntity getStudentByIdStudent() {
        return studentByIdStudent;
    }

    public void setStudentByIdStudent(StudentEntity studentByIdStudent) {
        this.studentByIdStudent = studentByIdStudent;
    }

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id")
    public CourseEntity getCourseByIdCourse() {
        return courseByIdCourse;
    }

    public void setCourseByIdCourse(CourseEntity courseByIdCourse) {
        this.courseByIdCourse = courseByIdCourse;
    }
}
