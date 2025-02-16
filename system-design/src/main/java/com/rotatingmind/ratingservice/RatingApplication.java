package com.rotatingmind.ratingservice;

import com.rotatingmind.ratingservice.controller.QuestionController;
import com.rotatingmind.ratingservice.controller.SurveyController;
import com.rotatingmind.ratingservice.controller.UserController;
import com.rotatingmind.ratingservice.domain.*;
import com.rotatingmind.ratingservice.repository.QuestionRepository;
import com.rotatingmind.ratingservice.repository.ResponseRepositoryImpl;
import com.rotatingmind.ratingservice.repository.SurveyRepository;
import com.rotatingmind.ratingservice.repository.UserRepository;
import com.rotatingmind.ratingservice.services.*;
import com.rotatingmind.ratingservice.utils.SurveyDataGenerator;

import java.util.HashSet;
import java.util.List;

/**
 * Best Approach?
 * If questions always have four fixed options → Use Option 1 (Include options in createQuestion).
 * If options are dynamic or editable later → Use Option 2 (Separate API to manage options).
 */
public class RatingApplication {

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserServiceImpl(userRepository);
        UserController userController = new UserController(userService);

        SurveyRepository surveyRepository = new SurveyRepository();
        QuestionRepository questionRepository = new QuestionRepository();
        ResponseRepositoryImpl resRepository = new ResponseRepositoryImpl();
        SurveyService surveyService = new SurveyServiceImpl(surveyRepository, userRepository, questionRepository, resRepository);

        SurveyController surveyController = new SurveyController(surveyService);

        QuestionService questionService = new QuestionServiceImpl(questionRepository, resRepository);
        QuestionController questionController = new QuestionController(questionService);


        SurveyUser admin = SurveyUser.builder()
                .email("sandi1@gmail.com")
                .phone("2222567890")
                .userName("sandi15")
                .userId(1001L)
                .userRole(UserRole.ADMIN)
                .activeSurvey(new HashSet<>())
                .closedSurvey(new HashSet<>())
                .build();

        userController.registerUser(admin);

        SurveyUser surveyUser2 = SurveyUser.builder()
                .email("ambuj1@gmail.com")
                .phone("1234567890")
                .userName("ambuj01")
                .userId(1002L)
                .userRole(UserRole.USER)
                .activeSurvey(new HashSet<>())
                .closedSurvey(new HashSet<>())
                .build();

        userController.registerUser(surveyUser2);


        SurveyUser surveyUser3 = SurveyUser.builder()
                .email("anuj01@gmail.com")
                .phone("1233337890")
                .userName("anuj01")
                .userId(1003L)
                .activeSurvey(new HashSet<>())
                .closedSurvey(new HashSet<>())
                .userRole(UserRole.USER)
                .build();

        userController.registerUser(surveyUser3);

        SurveyUser surveyUser4 = SurveyUser.builder()
                .email("banu01@gmail.com")
                .phone("1233876890")
                .userName("banu22")
                .userId(1004L)
                .activeSurvey(new HashSet<>())
                .closedSurvey(new HashSet<>())
                .userRole(UserRole.USER)
                .build();

        userController.registerUser(surveyUser4);

        SurveyUser surveyUser5 = SurveyUser.builder()
                .email("boby01@gmail.com")
                .phone("0003337890")
                .userName("boby01")
                .userId(1005L)
                .activeSurvey(new HashSet<>())
                .closedSurvey(new HashSet<>())
                .userRole(UserRole.USER)
                .build();

        userController.registerUser(surveyUser5);


        //create question
        var questions = List.of(questionController.createQuestion(1L, "How satisfied are you with the service?", SurveyDataGenerator.createSampleOptions(1L), admin.getUserId()),
        questionController.createQuestion(2L, "Would you recommend us to a friend?", SurveyDataGenerator.createSampleOptions(2L), admin.getUserId()));

        // create survey
        Survey survey = SurveyDataGenerator.createSurvey(2001L, "Customer Satisfaction Survey", admin.getUserId(), questions);
        survey  =surveyController.createSurvey(survey, admin.getUserId());
        System.out.println("New Survey " + survey.getSurveyId() + " Has been created");

        //assign to users
        userService.assignSurveys(2001L, List.of(1004L, 1005L));

        //user 1004L response
        Response res1 = new Response();

        res1.setSurveyId(2001L);
        res1.setResId(10L);
        res1.setUserId(1004L);

        Answer a1 = new Answer();
        a1.setId(1L);
        a1.setWeightage(4.0);
        a1.setQuestionId(1L);
        a1.setAnswerText("Satisfied");

        Answer a2 = new Answer();
        a2.setId(2L);
        a2.setWeightage(2.0);
        a2.setQuestionId(2L);
        a2.setAnswerText("Neutral");

        res1.setAnswers(List.of(a1, a2));

        surveyService.submit(2001L, 1004L, res1);


        //user 1005L response
        Response res2 = new Response();

        res1.setSurveyId(2001L);
        res1.setResId(10L);
        res1.setUserId(1004L);

        Answer a3 = new Answer();
        a3.setId(3L);
        a3.setWeightage(2.0);
        a3.setQuestionId(1L);
        a3.setAnswerText("Dissatisfied");

        Answer a4 = new Answer();
        a4.setId(4L);
        a4.setWeightage(5.0);
        a4.setQuestionId(2L);
        a4.setAnswerText("Very Satisfied");

        res2.setAnswers(List.of(a3, a4));

        surveyService.submit(2001L, 1005L, res2);


        //get question rating

        Double questionRating = questionController.getQuestionRating(2001L, 2L);

        System.out.println("Question 'Would you recommend us to a friend?': has " + questionRating + " Rating");


        Double surveyRating = surveyController.getSurveyRating(2001L, 1001L);

        System.out.println("Survey  " + 2001L + " has " + surveyRating + " Rating.");
    }
}
