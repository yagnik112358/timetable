package com.example.erp.dao.implementation;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Employees;
import com.example.erp.dao.CourseDao;
import com.example.erp.utils.SessionUtil;
import com.example.erp.wrap.Wrapping;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public List<Course_Schedule> getList(List<Courses> coursesList) {
        try (Session session = SessionUtil.getSession()) {
            Wrapping wrapping = new Wrapping();
            Course_Schedule course_schedule = new Course_Schedule();
            for (Courses item : coursesList) {
                Query query = session.createQuery("from Course_Schedule where course_id=:course_id");
                query.setParameter("course_id", item.getCourse_id());
                for (final Object fetch : query.list()) {
                    course_schedule = (Course_Schedule) fetch;
                    wrapping.insertSchedule(item,course_schedule);
                }
            }
        }
        return null;
    }

    @Override
    public Employees getFaculty(List<Courses> coursesList) {
        try (Session session = SessionUtil.getSession()) {
            Wrapping wrapping = new Wrapping();
            for (Courses item : coursesList) {
                Query query = session.createNativeQuery("select CONCAT(Employees.first_name,' ',Employees.last_name) from Courses,Employees where Courses.employee_id = Employees.employee_id and course_id=:course_id");
                query.setParameter("course_id", item.getCourse_id());
                for (final Object fetch : query.list()) {
                    String faculty = (String) fetch;
                    wrapping.insertEmployee(item.getName(),faculty);
                }
            }
        }
        catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
