package com.CourseDemo.Service;

import com.CourseDemo.Exception.StudentNotFoundException;
import com.CourseDemo.Repository.courseRepo;
import com.CourseDemo.Repository.studentRepo;
import com.CourseDemo.model.course;
import com.CourseDemo.model.student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentService
{
    @Autowired
    private studentRepo studentRepo;

    @Autowired
    private courseRepo courseRepo;

    private static Logger logger= LoggerFactory.getLogger(StudentService.class);

    public List<course> getCourseForStudent(int id)
    {
        List name=new ArrayList<course>();
        student st=studentRepo.findById(id);
        if(st!=null)
        {
            return st.getCourses();
        }else if(st==null)
        {
            logger.error("student not registered,error thrown");
            throw new StudentNotFoundException("student not found with this id");
        }
        List<course> courses=st.getCourses();
        for(course Course:courses)
        {
            name.add(Course.getName());
        }

      return name;
    }
}
