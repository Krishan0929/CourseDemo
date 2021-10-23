package com.CourseDemo.Repository;

import com.CourseDemo.model.student_course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface studentCourseRepo extends JpaRepository<student_course,Integer>
{

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM student_course WHERE course_id=? and student_id=?",nativeQuery = true)
    void delete1(@Param("course_id") int course_id,@Param("student_id")int student_id);

    @Modifying(flushAutomatically = true,clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE student_course SET course_id =:course_id WHERE student_id=:student_id ",nativeQuery = true)
    void update1(@Param("student_id")int student_id,@Param("course_id") int course_id);

    List<student_course> findAllById(Integer id);


    @Modifying
    @Transactional
    @Query(value = "delete from student_course u where u.student_id in(:user)",nativeQuery = true)
    void deleteByIdIn(List<student_course> user);

   /* @Modifying
    @Transactional
    @Query(value = "DELETE FROM student_course WHERE course_id=? and student_id=?",nativeQuery = true)
    void deleteMultiple(@Param("course_id") int fordelete,@Param("student_id")int student_id);*/
}
