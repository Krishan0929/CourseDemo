package com.CourseDemo.Repository;

import com.CourseDemo.model.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface courseRepo extends JpaRepository<course,Integer> {
    course save(course cs);
    course findById(int id);
}
