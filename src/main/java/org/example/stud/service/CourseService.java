package org.example.stud.service;

import lombok.extern.slf4j.Slf4j;
import org.example.stud.model.Course;
import org.example.stud.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public void saveCourses(List<Course> courses) {
        courseRepository.saveAll(courses);
        log.info("All courses got saved");
    }
}
