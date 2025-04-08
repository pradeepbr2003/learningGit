package org.example.stud.provider;

import org.example.common.config.UserConfiguration;
import org.example.stud.model.Course;
import org.example.stud.model.Student;
import org.example.stud.service.CourseService;
import org.example.stud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

@Component
public class StudentProvider {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserConfiguration config;


    @Bean
    public List<Student> students() {
        Random random = new Random();
        List<Student> students = IntStream.range(0, config.getUsername().length).mapToObj(i -> Student.builder()
                .studId(i + 1l).studName(config.getUsername()[i])
                .build()).toList();

        List<Course> courses = IntStream.range(0, config.getSkillSet().length).mapToObj(i -> Course.builder()
                .courseId(i + 101l).courseName(config.getSkillSet()[i])
                .build()).toList();
        studentService.saveStudents(students);
        courseService.saveCourses(courses);

        students.forEach(stud -> {
            List<Course> courseList = new ArrayList<>();
            for (int i = 0, j = 3; i <= 6; i += 3, j += 3) {
                Course course = courses.get(random.nextInt(i, j));
                courseList.add(course);
            }
            courseList.add(courses.get(config.getSkillSet().length - 1));
            stud.setCourses(courseList);
        });
        studentService.saveStudents(students);
        return students;
    }

}
