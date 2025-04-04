package org.example.job.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProfileDTO {
    private Long id;
    private String bio;
}
