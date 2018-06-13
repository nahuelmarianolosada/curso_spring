package com.incluit.springapp.web.model.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Collection;
import java.util.Date;

/**
 * Created by nlosada on 30/05/18.
 */



@NamedNativeQueries({
        @NamedNativeQuery(name = "getStudentsByCourse",
                query = "SELECT s.id, s.first_name, s.last_name, s.birthday\n" +
                        "FROM STUDENT s\n" +
                        "  INNER JOIN STUDENT_COURSE sc ON s.id = sc.id_student\n" +
                        "WHERE sc.id_course = :idCourse",
                        resultClass = StudentEntity.class)
})
@Entity
@Table(name = "STUDENT", schema = "school_schema")
public class StudentEntity {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    /*private Collection<StudentCourseEntity> studentCoursesById;*/

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
    @Column(name = "first_name", nullable = true, length = 50)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name", nullable = true, length = 50)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    /*@OneToMany(mappedBy = "studentByIdStudent",cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    public Collection<StudentCourseEntity> getStudentCoursesById() {
        return studentCoursesById;
    }

    public void setStudentCoursesById(Collection<StudentCourseEntity> studentCoursesById) {
        this.studentCoursesById = studentCoursesById;
    }*/
}
