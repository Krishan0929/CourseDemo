package com.CourseDemo.Service;


import com.CourseDemo.Exception.StudentNotFoundException;
import com.CourseDemo.Repository.courseRepo;
import com.CourseDemo.Repository.studentCourseRepo;
import com.CourseDemo.Repository.studentRepo;
import com.CourseDemo.model.course;
import com.CourseDemo.model.student;
import com.CourseDemo.model.student_course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService
{

    @Autowired
    private studentRepo studentRepo;

    @Autowired
    private courseRepo courseRepo;

    @Autowired
    private studentCourseRepo studentCourseRepo;

    private static Logger logger= LoggerFactory.getLogger(StudentService.class.getName());


    public List<course> getCourseForStudent ( int id)
        {
            List name = new ArrayList<course>();
            student st = studentRepo.findById(id);
            if (st != null) {
                return st.getCourses();
            } else if (st == null) {
                logger.error("student not registered,error thrown");
                throw new StudentNotFoundException("student not found with this id");
            }
            List<course> courses = st.getCourses();
            for (course Course : courses) {
                name.add(Course.getName());
            }

            return name;
        }

        public student createStudent(student student)
        {
            List<course> coursesList= student.getCourses();
            if(!CollectionUtils.isEmpty(coursesList)){
                for(course ref : coursesList){
                    logger.info("course object :"+ ref);
            createCourse(ref);}}
            student st=studentRepo.save( student);
            logger.debug("student return data :" + st);

            return st;
        }
        public course createCourse(course cs){
            course data=courseRepo.save(cs);
            logger.info("course data :" + data);
           return data;


        }

        public void delete(int id)
        {
             studentRepo.deleteById(id);
             courseRepo.deleteById(id);
        }

        /*public student createStudent(student student)
        {
            return studentRepo.save(student);
        }*/
        public List<student> getStudentForCourse ( int id) {

          /*  course st = courseRepo.findById(id);
            if (st != null) {
                return st.getStudents();
            } else if (st == null) {
                logger.error("student not registered,error thrown");
                throw new StudentNotFoundException("student not found with this id");
            }
          return st.getStudents();
        }*/
            List name = new ArrayList<student>();
            List<student> students = courseRepo.findById(id).getStudents();
            for (student Course : students) {
                name.add(Course.getFirst_name());
                name.add(Course.getDob());
            }

            return name;
        }

    public void delete(int student_id, int course_id) {
        // studentCourseRepo.deleteByMtehod(student_id,course_id);
        /*student_course ob=new student_course();
        ob.setStudent_id(student_id);
        ob.setCourse_id(course_id);*/
        studentCourseRepo.delete1(course_id,student_id);


    }
    public void update(int student_id, int course_id) {

      /*Optional<student_course> user1=studentCourseRepo.findById(student_id);
        student_course User=user1.get();
        if(User.getId()&&User.getStudent_id())
        {

        }
        student_course ob = new student_course();
      int user = ob.getId();*/
        studentCourseRepo.update1(student_id, course_id);


    }
    public void deleteMultipleCourses(int student_id) {
                  List name=new ArrayList<>();
                   List<student_course> user=studentCourseRepo.findAllById(student_id);
                    for(student_course studentid:user)
                    {
                       name.add(studentid.getStudent_id());
                    }

              studentCourseRepo.deleteByIdIn(name);

        /*List name = new ArrayList<student>();
        List<student_course> students = (List<student_course>) studentCourseRepo.findById(student_id).get();
        for (student_course Course : students) {
            name.add(Course.getStudent_id());*/

        }
      // studentCourseRepo.deleteMultiple(student_id,fordelete);



    }

