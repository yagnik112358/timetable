package com.example.erp.bean;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Courses implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;

    @Column(nullable = false,unique = true)
    private String course_code;

    @Column(nullable = false)
    private String name;

    private Integer employee_id;

    @ManyToOne
    @JoinColumn(name="employee_id", nullable=false,insertable = false,updatable = false)
    private Employees employees;

    @OneToMany(mappedBy="courses")
    private List<Course_Schedule> course_schedules;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Specialisation> specialisations;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "Course_TA", joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")})
    private List<Students> studentsta;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Students> students;

    public Courses(){

    }

    public Courses(String course_code, String name, Integer employee_id) {
        this.course_code = course_code;
        this.name = name;
        this.employee_id = employee_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getemployee_id() {
        return employee_id;
    }

    public void setemployee_id(Integer employee_id) {
        this.employee_id = employee_id;
    }

    public List<Course_Schedule> getCourse_schedules() {
        return course_schedules;
    }

    public void setCourse_schedules(List<Course_Schedule> course_schedules) {
        this.course_schedules = course_schedules;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }

    public List<Specialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(List<Specialisation> specialisations) {
        this.specialisations = specialisations;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }


    public List<Students> getStudentsta() {
        return studentsta;
    }

    public void setStudentsta(List<Students> studentsta) {
        this.studentsta = studentsta;
    }
}
