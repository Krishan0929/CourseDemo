package com.CourseDemo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class course
{

    @Id
    @Column(name = "course_id")
    private int id;

    private String name;

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    /*@JoinTable(name="student_course",
            joinColumns = {@JoinColumn(name="course_id",referencedColumnName="course_id")},
            inverseJoinColumns ={@JoinColumn(name = "student_id",referencedColumnName = "student_id")})*/
    private List<student> students;


}
