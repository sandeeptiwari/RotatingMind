package com.rotatingmind.ratingservice.services;

import com.rotatingmind.ratingservice.domain.SurveyUser;
import com.rotatingmind.ratingservice.repository.UserRepository;

import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SurveyUser addUser(SurveyUser user) {
        return userRepository.save(user).orElseThrow(() -> new RuntimeException("User already exists"));
    }


    @Override
    public boolean assignSurvey(Long surveyId, Long userId) {
        SurveyUser surveyUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found " + userId));
        surveyUser.getActiveSurvey().add(surveyId);
        userRepository.save(surveyUser);
        return true;
    }

    @Override
    public boolean assignSurveys(Long surveyId, List<Long> userIds) {
        List<SurveyUser> surveyUsers = userRepository.findByIds(userIds);
        surveyUsers.stream().filter(Objects::nonNull).forEach(user -> {
                    user.getActiveSurvey().add(surveyId);
                });

        userRepository.saveAll(surveyUsers);

        return true;
    }
}
