package org.example.stud.dto.util;

import org.example.stud.dto.CourseDTO;
import org.example.stud.dto.StudentDTO;
import org.example.stud.model.Course;
import org.example.stud.model.Student;

import java.util.List;

public enum StudentUtilEnum {
    STUDENT_UTIL;

    public StudentDTO build(Student student) {
        List<Course> courses = student.getCourses();
        return StudentDTO.builder()
                .studId(student.getStudId()).studName(student.getStudName())
                .courses(prepareCourse(courses))
                .build();
    }

    private List<CourseDTO> prepareCourse(List<Course> courses) {
        return courses.stream()
                .map(c -> CourseDTO.builder()
                        .courseId(c.getCourseId()).courseName(c.getCourseName())
                        .build()).toList();
    }

    public List<StudentDTO> build(List<Student> students) {
        return students.stream().map(this::build).toList();
    }
}
