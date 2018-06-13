package com.incluit.springapp.web.model.domain;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by nlosada on 30/05/18.
 */


@NamedNativeQueries({
        @NamedNativeQuery(name = "getCoursesByProfessor",
                query = "SELECT c.* FROM COURSE c\n" +
                        "INNER JOIN COURSE_PROFESSOR cp ON c.id = cp.id_course\n" +
                        "WHERE cp.id_professor = :idProfessor",
                        resultClass = CourseEntity.class)
})
@Entity
@Table(name = "COURSE", schema = "school_schema", catalog = "")
public class CourseEntity {
    private int id;
    private String signature;
    private String place;
    /*private Collection<CourseProfessorEntity> courseProfessorsById;
    private Collection<StudentCourseEntity> studentCoursesById;*/

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "signature", nullable = true, length = 50)
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Basic
    @Column(name = "place", nullable = true, length = 50)
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (id != that.id) return false;
        if (signature != null ? !signature.equals(that.signature) : that.signature != null) return false;
        if (place != null ? !place.equals(that.place) : that.place != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (signature != null ? signature.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "courseByIdCourse")
    public Collection<CourseProfessorEntity> getCourseProfessorsById() {
        return courseProfessorsById;
    }

    public void setCourseProfessorsById(Collection<CourseProfessorEntity> courseProfessorsById) {
        this.courseProfessorsById = courseProfessorsById;
    }

    @OneToMany(mappedBy = "courseByIdCourse")
    public Collection<StudentCourseEntity> getStudentCoursesById() {
        return studentCoursesById;
    }

    public void setStudentCoursesById(Collection<StudentCourseEntity> studentCoursesById) {
        this.studentCoursesById = studentCoursesById;
    }*/
}
