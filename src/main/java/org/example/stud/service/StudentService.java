package org.example.stud.service;

import lombok.extern.slf4j.Slf4j;
import org.example.stud.dto.StudentDTO;
import org.example.stud.model.Student;
import org.example.stud.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.example.stud.dto.util.StudentUtilEnum.STUDENT_UTIL;

@Slf4j
@Service
public class StudentService {

    @Autowired
    private StudentRepository studRepo;

    public List<StudentDTO> getAllStudents() {
        return STUDENT_UTIL.build(studRepo.findAll());
    }

    public StudentDTO getStudent(Long studId) {
        Optional<Student> optStudent = studRepo.findById(studId);
        if (optStudent.isPresent()) {
            return STUDENT_UTIL.build(optStudent.get());
        }
        return StudentDTO.builder().build();
    }

    public void saveStudents(List<Student> students) {
        studRepo.saveAll(students);
        log.info("All Students got saved");
    }
}
