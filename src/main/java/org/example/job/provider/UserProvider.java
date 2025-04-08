package org.example.job.provider;

import org.example.common.config.UserConfiguration;
import org.example.job.model.JobSeeker;
import org.example.job.model.Profile;
import org.example.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class UserProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConfiguration config;

    @Bean
    public List<JobSeeker> users() {
        List<JobSeeker> users = IntStream.range(0, config.getSkillSet().length)
                .mapToObj(i ->
                        JobSeeker.builder().username(config.getUsername()[i])
                                .profile(Profile.builder().bio(config.getSkillSet()[i]).build())
                                .build()).toList();

        userService.saveUsers(users);
        return users;
    }
}
