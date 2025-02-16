package com.rotatingmind.ratingservice.services;

import com.rotatingmind.ratingservice.domain.*;
import com.rotatingmind.ratingservice.repository.*;

import java.util.List;
import java.util.Objects;

public class SurveyServiceImpl implements SurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final ResponseRepositoryImpl resRepository;

    public SurveyServiceImpl(SurveyRepository surveyRepository,
                             UserRepository userRepository,
                             QuestionRepository questionRepository,
                             ResponseRepositoryImpl resRepository) {
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.resRepository = resRepository;
    }

    @Override
    public Survey create(Survey survey, Long userId) {
        preCheckRequest(userId);
        return surveyRepository.save(survey).orElseThrow(() -> new RuntimeException("Survey could not be created"));
    }

    @Override
    public Survey addQuestions(Long surveyId, List<Long> questionIds, Long userId) {
        preCheckRequest(userId);
        List<Question> questions = questionRepository.findByIds(questionIds);
        Survey survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException("Survey is not found: " + surveyId));
        survey.setQuestions(questions);
        return surveyRepository.save(survey).orElseThrow(() -> new RuntimeException("Unable to add question into Survey : " + surveyId));
    }

    @Override
    public Survey addQuestion(Long surveyId, Long questionId, Long userId) {
        return null;
    }

    @Override
    public Double fetchSurveyRating(Long surveyId, Long userId) {
        preCheckRequest(userId);
        var responses = resRepository.findBySurveyId(surveyId);
        return responses.stream().map(res -> {
            var answers = res.getAnswers();
            return answers.stream().mapToDouble(Answer::getWeightage).average().orElse(0.0);
        }).mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    @Override
    public Survey findById(Long surveyId, Long userId) {
        preCheckRequest(userId);
        return surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException("Survey is not found: " + surveyId));
    }

    @Override
    public List<Survey> findAll(Long userId) {
        preCheckRequest(userId);
        return surveyRepository.findAll();
    }

    @Override
    public boolean update(Survey survey) {
        var newSurvey = surveyRepository.save(survey).orElseThrow(() -> new RuntimeException("Unable to update the survey " + survey.getSurveyId()));
        return true;
    }

    @Override
    public boolean delete(Long surveyId) {
        surveyRepository.delete(surveyId);
        return true;
    }

    private void preCheckRequest(Long userId) {
        SurveyUser user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found " + userId));
        if (user.getUserRole() != UserRole.ADMIN) {
            throw new RuntimeException("User is not admin " + userId);
        }
    }

    @Override
    public boolean removeQuestion(Long surveyId, Long questionId, Long userId) {
        preCheckRequest(userId);
        var survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException("Survey is not found: " + surveyId));
        survey.getQuestions().removeIf(q -> Objects.equals(q.getQuestionId(), questionId));
        surveyRepository.save(survey);
        return false;
    }

    @Override
    public boolean submit(Long surveyId, Long userId, Response response) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey not found " + surveyId));

        SurveyUser surveyUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        boolean isSurveyAssigned = surveyUser.getActiveSurvey().contains(surveyId);

        boolean isAlreadyCompleted = surveyUser.getClosedSurvey().contains(surveyId);

        if (!isSurveyAssigned && isAlreadyCompleted) {
            throw new IllegalStateException("Survey already submitted.");
        } else if (!isSurveyAssigned) {
            throw new IllegalStateException("Survey :  " + surveyId + " is not assigned  to " + userId);
        }

        // Validation and business logic to ensure valid submission
        if (!survey.isActive()) {
            throw new IllegalStateException("Survey is closed. " + survey.getSurveyId());
        }

        response.setSurveyId(surveyId);
        response.setUserId(userId);
        resRepository.save(response);
        return true;
    }

    @Override
    public boolean close(Long surveyId, Long userId) {
        preCheckRequest(userId);
        var survey = surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException("Survey is not found: " + surveyId));
        survey.setActive(false);
        surveyRepository.save(survey);
        return false;
    }

    @Override
    public List<Response> getSurveyResponse(Long surveyId) {
        return resRepository.findBySurveyId(surveyId);
    }
}
