package com.CourseDemo.Controller;

import com.CourseDemo.Service.StudentService;
import com.CourseDemo.model.course;
import com.CourseDemo.model.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    public StudentService studentService;

    @GetMapping("/students/{student_id}/courses")
    public List<course> getCourseForStudent(@PathVariable(name = "student_id") int id) {
        return studentService.getCourseForStudent(id);
    }

    @PostMapping("/students")
    public student createStudent(@RequestBody student student) {
        return studentService.createStudent(student);
    }

    /*@DeleteMapping("/students/{student_id}")
    public void deleteStudent(@PathVariable("student_id") int id)
    {
        studentService.delete(id);
    }*/
    @GetMapping("/students/{course_id}/students")
    public List<student> getStudentForCourse(@PathVariable(name = "course_id") int id) {
        return studentService.getStudentForCourse(id);
    }

    @DeleteMapping("/students/{student_id}/course/{course_id}")
    public void deleteMethod(@PathVariable(name = "student_id") int id1, @PathVariable(name = "course_id") int id)
    {
        studentService.delete(id1, id);
    }

    @PutMapping("/students/{student_id}/course/{course_id}")
    public void update(@PathVariable(name = "student_id") int id1, @PathVariable(name = "course_id") int id)
    {
        studentService.update(id1, id);
    }

    @DeleteMapping("/students/{student_id}")
    public void deleteMultipleCourses(@PathVariable(name = "student_id") int id)
    {
        studentService.deleteMultipleCourses(id);
    }



    // checking to a single file upload on git hub
    //one more commit
}
