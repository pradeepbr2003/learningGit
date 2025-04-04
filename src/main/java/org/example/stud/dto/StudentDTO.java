package org.example.stud.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class StudentDTO {
    private Long studId;
    private String studName;
    private List<CourseDTO> courses;

}
