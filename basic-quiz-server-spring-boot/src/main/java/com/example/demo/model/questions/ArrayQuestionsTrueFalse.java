package com.example.demo.model.questions;

import java.util.ArrayList;
import java.util.List;

public class ArrayQuestionsTrueFalse {
    private static List<QuestionTrueFalse> arrayListQuestionsTF = new ArrayList<QuestionTrueFalse>();
    private int totalQuestions = 0;

    public ArrayQuestionsTrueFalse() {
        arrayListQuestionsTF.add(new QuestionTrueFalse("The earth is the 3rd planet from its star", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("The earth and mars have the same atmosphere", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Saturn in the largest planet", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Jupiter in the largest planet", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Venus is hotter than Mercury despite being farther from the Sun", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Uranus rotates on its side compared to other planets", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Pluto is still officially classified as a major planet", false));
        arrayListQuestionsTF.add(new QuestionTrueFalse("Mars has two moons named Phobos and Deimos", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("The Sun is considered a medium-sized star", true));
        arrayListQuestionsTF.add(new QuestionTrueFalse("No planets are retrograde in our solar system", false));
        totalQuestions = arrayListQuestionsTF.size();
    }

    public QuestionTrueFalse nextQuestion(int i) {
        return arrayListQuestionsTF.get(i % totalQuestions);
    }
    
}