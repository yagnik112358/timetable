package com.example.erp.dao;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Employees;

import java.util.List;

public interface CourseDao{
    List<Course_Schedule> getList(List<Courses> coursesList);
    Employees getFaculty(List<Courses> coursesList);
}
