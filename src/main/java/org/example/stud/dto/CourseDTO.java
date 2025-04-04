package org.example.stud.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CourseDTO {
    private Long courseId;
    private String courseName;
}
