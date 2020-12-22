package com.example.erp.controller;

import com.example.erp.bean.Course_Schedule;
import com.example.erp.bean.Employees;
import com.example.erp.service.CourseService;
import com.example.erp.wrap.Wrapping;
import com.example.erp.bean.Courses;
import com.example.erp.bean.Students;
import com.example.erp.service.StudentService;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.JsonArray;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.util.List;

@Path("students")
public class StudentsController {
    StudentService studentService = new StudentService();
    CourseService courseService = new CourseService();

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response loginStudent(Students student) throws URISyntaxException {
        Students result = studentService.verifyEmail(student);
        if(result == null){
            return Response.noContent().build();
        }

        return Response.ok().entity(result.getEmail()).build();
    }

    @POST
    @Path("/timetable")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getCourses(Students students) throws URISyntaxException{
        List<Courses> coursesList = studentService.getCourses(students);
        if(coursesList.size() > 0){
            List<Course_Schedule> course_schedules = courseService.getschedule(coursesList);
            Employees employees = courseService.getEmployee(coursesList);
            JSONObject result = new JSONObject();
            result.put("courses",Wrapping.getCoursearray());
            String temp = result.toString();
            return Response.ok().entity(temp).build();
        }
        else {
            return Response.noContent().build();
        }
    }
}
