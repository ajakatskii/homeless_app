package com.damon.literarium.data.repository;

import com.damon.literarium.data.Attendance;
import com.damon.literarium.data.Quiz;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QuizSeedData {

    public static ArrayList<Quiz> getQuizList()
    {
        ArrayList<Quiz> quizes = new ArrayList<>();
        quizes.add(
            new Quiz(
                "Maths: Differentiation",
                "20-28",
                35,
                7
            )
        );
        quizes.add(
            new Quiz(
                    "History: Cricket",
                    "8-18",
                    20,
                    15
            )
        );
        quizes.add(
            new Quiz(
                    "Civics: Laws",
                    "25-45",
                    35,
                    7
            )
        );
        quizes.add(
            new Quiz(
                    "English Grammar: Tense",
                    "36-56",
                    30,
                    5
            )
        );
        quizes.add(
            new Quiz(
                    "Mathematics: Interests",
                    "24-36",
                    50,
                    12
            )
        );
        quizes.add(
            new Quiz(
                    "Mathematics: Geometry",
                    "30-56",
                    40,
                    20
            )
        );
        quizes.add(
            new Quiz(
                    "Hindi: Grammar",
                    "7-17",
                    35,
                    10
            )
        );
        quizes.add(
            new Quiz(
                    "Biology: Organisms",
                    "37-42",
                    20,
                    10
            )
        );
        quizes.add(
            new Quiz(
                    "Biology: Plants",
                    "15-25",
                    20,
                    5
            )
        );
        quizes.add(
            new Quiz(
                    "Sanskrit: Tatpareya",
                    "48-78",
                    30,
                    10
            )
        );
        return quizes;
    }

}
