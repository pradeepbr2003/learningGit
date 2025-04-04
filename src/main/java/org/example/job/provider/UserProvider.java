package org.example.job.provider;

import org.example.job.model.JobSeeker;
import org.example.job.model.Profile;
import org.example.job.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

import static org.example.common.CommonUtilEnum.SKILL_SET;
import static org.example.common.CommonUtilEnum.USER_NAME;

@Component
public class UserProvider {

    @Autowired
    private UserService userService;

    @Bean
    public List<JobSeeker> users() {
        List<JobSeeker> users = IntStream.range(0, SKILL_SET.length())
                .mapToObj(i ->
                        JobSeeker.builder().username(USER_NAME.skill()[i])
                                .profile(Profile.builder().bio(SKILL_SET.skill()[i]).build())
                                .build()).toList();

        userService.saveUsers(users);
        return users;
    }
}
