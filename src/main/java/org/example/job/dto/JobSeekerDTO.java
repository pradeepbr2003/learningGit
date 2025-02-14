package org.example.job.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class JobSeekerDTO {
    private Long id;
    private String username;
    private ProfileDTO profile;
}
