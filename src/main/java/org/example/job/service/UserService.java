package org.example.job.service;

import lombok.extern.slf4j.Slf4j;
import org.example.job.dto.JobSeekerDTO;
import org.example.job.model.JobSeeker;
import org.example.job.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.job.dto.util.JobUtilEnum.JOB_UTIL;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<JobSeekerDTO> getAllUsers() {
        return JOB_UTIL.build(userRepository.findAll());
    }

    public void saveUsers(List<JobSeeker> users) {
        userRepository.saveAll(users);
        log.info("All users got saved");
    }
}
