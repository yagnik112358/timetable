package com.example.erp.wrap;

import com.example.erp.bean.*;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.bind.annotation.JsonbTransient;
import java.util.List;

public class Wrapping {
    private static JSONArray coursearray = new JSONArray();

    Students students;
    Courses courses;
    Course_Schedule course_schedule;
    Employees employees;
    Specialisation specialisation;

    public void makeCourse(List<Courses> coursesList){
        JSONObject result = new JSONObject();
        for(Courses item : coursesList){
            coursearray.put(item.getName());
        }
        result.put("courses",coursearray);
        System.out.println(result.toString());

    }

    public void insertSchedule(Courses courses,Course_Schedule course_schedule){
        JSONObject result = new JSONObject();
        result.put("name",courses.getName());
        result.put("time",course_schedule.getTime());
        result.put("day",course_schedule.getDay());
        result.put("room",course_schedule.getRoom());
        result.put("faculty","");
        result.put("ta", courses.getStudentsta());
        result.put("specialisation",courses.getSpecialisations());
        coursearray.put(result);
    }

    public void insertEmployee(String name,String faculty){
        for(int i=0;i<coursearray.length();i++){
            JSONObject itemArr = (JSONObject)coursearray.get(i);
            if(itemArr.get("name")==name){
                itemArr.put("faculty",faculty);
            }
        }
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Course_Schedule getCourse_schedule() {
        return course_schedule;
    }

    public void setCourse_schedule(Course_Schedule course_schedule) {
        this.course_schedule = course_schedule;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }

    public static JSONArray getCoursearray() {
        return coursearray;
    }

    public static void setCoursearray(JSONArray coursearray) {
        Wrapping.coursearray = coursearray;
    }
}
