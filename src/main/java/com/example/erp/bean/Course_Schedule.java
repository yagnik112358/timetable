package com.example.erp.bean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Course_Schedule")
public class Course_Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer course_id;

    @Column(nullable = false)
    private String time;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String room;

    @ManyToOne
    @JoinColumn(name="course_id", nullable=false, insertable = false,updatable = false)
    private Courses courses;

    public Course_Schedule(){

    }

    public Course_Schedule(Integer course_id, String time, String day, String room) {
        this.course_id = course_id;
        this.time = time;
        this.day = day;
        this.room = room;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
