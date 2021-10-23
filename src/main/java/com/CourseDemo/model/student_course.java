package com.CourseDemo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class student_course
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_id")
    //@OneToOne
    //@JoinColumn(name = "student_id")
    private int student_id;

    @Column(name = "course_id")
   // @OneToOne
   // @JoinColumn(name = "course_id")
    private int course_id;

    public student_course(int student_id, int course_id) {
    }
}
