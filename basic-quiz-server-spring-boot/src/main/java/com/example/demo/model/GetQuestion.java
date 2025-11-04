/*package com.example.demo.model;

import com.example.demo.model.*;
import com.example.demo.model.questions.*;

public class GetQuestion {
    private static ArrayQuestionsTrueFalse arrayListQuestionsTF = new ArrayQuestionsTrueFalse();

    public GetQuestion() { }

    public com.example.demo.model.questions.QuestionTrueFalse nextQuestion() {
        return arrayListQuestionsTF.nextQuestion(Count.count);
    }

}
*/

package com.example.demo.model;

import com.example.demo.model.questions.QuestionTrueFalse;
import java.util.List;
import java.util.Arrays;

public class GetQuestion {

    // keep a static index so questions advance across new instances
    private static int index = 0;

    // simple question list; adjust text/answers to match your domain
    private static final List<QuestionTrueFalse> QUESTIONS = Arrays.asList(
        new QuestionTrueFalse("The sky is blue.", Boolean.TRUE),
        new QuestionTrueFalse("2 + 2 = 5.", Boolean.FALSE),
        new QuestionTrueFalse("Java is a programming language.", Boolean.TRUE)
    );

    public QuestionTrueFalse nextQuestion() {
        QuestionTrueFalse q = QUESTIONS.get(index % QUESTIONS.size());
        index++;
        return q;
    }
}