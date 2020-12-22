package com.example.erp.service;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Employees;
import com.example.erp.bean.Students;
import com.example.erp.dao.CourseDao;
import com.example.erp.dao.StudentDao;
import com.example.erp.dao.implementation.CourseDaoImpl;
import com.example.erp.dao.implementation.StudentDaoImpl;

import java.util.List;

public class CourseService {
    StudentDao studentDao = new StudentDaoImpl();
    CourseDao courseDao = new CourseDaoImpl();
    public List<Course_Schedule> getschedule(List<Courses> coursesList){
        return courseDao.getList(coursesList);
    }
    public List<Courses> getCourses(Students students){
        return studentDao.coursesfetch(students);
    }
    public Employees getEmployee(List<Courses> coursesList){
        return courseDao.getFaculty(coursesList);
    }
}


