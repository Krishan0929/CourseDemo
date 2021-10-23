package com.CourseDemo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class student
{

    @Id
    @Column(name = "student_id")
    private int id;

  private String first_name;

  private String last_name;

  private String gender;

  //@JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
  @Column(name = "DOB")
  private String dob;


 // @JsonIgnore
  @ManyToMany
  @NotFound(action = NotFoundAction.IGNORE)
 // @JoinColumn(name = "course_id")
  @JoinTable(name="student_course",
          joinColumns = {@JoinColumn(name="student_id",referencedColumnName="student_id")},
          inverseJoinColumns ={@JoinColumn(name = "course_id",referencedColumnName = "course_id")})
  private List<course> courses;


    public List<course> getCourses() {
        return courses;
    }

    public void setCourses(List<course> courses) {
        this.courses = courses;
    }
}
