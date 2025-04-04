package org.example.job.dto.util;

import org.example.job.dto.JobSeekerDTO;
import org.example.job.dto.ProfileDTO;
import org.example.job.model.JobSeeker;
import org.example.job.model.Profile;

import java.util.List;

public enum JobUtilEnum {
    JOB_UTIL;

    public JobSeekerDTO build(JobSeeker jobSeeker) {
        Profile profile = jobSeeker.getProfile();
        return org.example.job.dto.JobSeekerDTO.builder()
                .id(jobSeeker.getId()).username(jobSeeker.getUsername())
                .profile(ProfileDTO.builder().id(profile.getId()).bio(profile.getBio())
                        .build())
                .build();
    }

    public List<JobSeekerDTO> build(List<JobSeeker> jobSeekers) {
        return jobSeekers.stream().map(this::build).toList();
    }
}
