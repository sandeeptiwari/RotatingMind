package com.rotatingmind.ratingservice.utils;

import com.rotatingmind.ratingservice.domain.Option;
import com.rotatingmind.ratingservice.domain.Question;
import com.rotatingmind.ratingservice.domain.Survey;
import com.rotatingmind.ratingservice.services.SurveyService;

import java.util.ArrayList;
import java.util.List;

public class SurveyDataGenerator {


    public static Survey createSurvey(Long surveyId, String name, Long userId, List<Question> questions) {
        return Survey.builder()
                .surveyId(surveyId)
                .name(name)
                .rating(0.0)
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .createdBy(userId)
                .isActive(true)
                .questions(questions)
                .build();
    }

    public static void generate(SurveyService surveyService, Long userId) {

        // Survey 1


        // Survey 2
        Survey survey2 = Survey.builder()
                .surveyId(2L)
                .name("Employee Engagement Survey")
                .rating(0.0)
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .createdBy(userId)
                .isActive(true)
                .questions(createSampleQuestions())
                .build();

        // Survey 3
        Survey survey3 = Survey.builder()
                .surveyId(3L)
                .name("Product Feedback Survey")
                .rating(0.0)
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .createdBy(userId)
                .isActive(true)
                .questions(createSampleQuestions())
                .build();

        // Survey 4
        Survey survey4 = Survey.builder()
                .surveyId(4L)
                .name("Market Research Survey")
                .rating(0.0)
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .createdBy(userId)
                .isActive(true)
                .questions(createSampleQuestions())
                .build();

        // Survey 5
        Survey survey5 = Survey.builder()
                .surveyId(5L)
                .name("Customer Support Feedback")
                .rating(0.0)
                .createdAt(System.currentTimeMillis())
                .updatedAt(System.currentTimeMillis())
                .createdBy(userId)
                .isActive(true) // This survey is inactive
                .questions(createSampleQuestions())
                .build();

        // Printing Surveys (for example purposes)
        //surveyService.create(survey1, userId);
        surveyService.create(survey2, userId);
        surveyService.create(survey3, userId);
        surveyService.create(survey4, userId);
        surveyService.create(survey5, userId);
    }

    // Method to create sample questions
    private static List<Question> createSampleQuestions() {
        List<Question> questions = new ArrayList<>();

        // Sample Question 1
        Question question1 = Question.builder()
                .questionId(1L)
                .question("How satisfied are you with the service?")
                .rating(0.0)
                .options(createSampleOptions(1L))
                .build();

        // Sample Question 2
        Question question2 = Question.builder()
                .questionId(2L)
                .question("Would you recommend us to a friend?")
                .rating(0.0)
                .options(createSampleOptions(2L))
                .build();

        questions.add(question1);
        questions.add(question2);

        return questions;
    }

    // Method to create sample options for each question
    public static List<Option> createSampleOptions(Long questionId) {
        List<Option> options = new ArrayList<>();

        Option option1 = Option.builder()
                .optionId(1L)
                .optionName("Very Satisfied")
                .weightage(5.0)
                .questionId(questionId)
                .build();

        Option option2 = Option.builder()
                .optionId(2L)
                .optionName("Satisfied")
                .weightage(4.0)
                .questionId(questionId)
                .build();

        Option option3 = Option.builder()
                .optionId(3L)
                .optionName("Neutral")
                .weightage(3.0)
                .questionId(questionId)
                .build();

        Option option4 = Option.builder()
                .optionId(4L)
                .optionName("Dissatisfied")
                .weightage(2.0)
                .questionId(questionId)
                .build();

        options.add(option1);
        options.add(option2);
        options.add(option3);
        options.add(option4);

        return options;
    }
}
