package com.example.erp.dao.implementation;

import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.dao.StudentDao;
import com.example.erp.utils.SessionUtil;
import javassist.bytecode.Descriptor;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Students emailVerify(Students student) {
        try (Session session = SessionUtil.getSession()) {
            Query query = session.createQuery("from Students where email=:email");
            query.setParameter("email", student.getEmail());
            for (final Object fetch : query.list()) {
                return (Students) fetch;
            }
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public List<Courses> coursesfetch(Students students) {
        try (Session session = SessionUtil.getSession()){
            Students students1 = new Students();
            Query query = session.createQuery("from Students where email=:email");
            query.setParameter("email",students.getEmail());
            for (final Object fetch : query.list()){
                students1 = (Students) fetch;
            }
            return students1.getCourses();
        }
    }
}
