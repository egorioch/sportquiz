package quiz.controller;

import org.springframework.web.bind.annotation.*;
import quiz.model.Question;
import quiz.repo.QuestionRepo;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:8000")
public class QuestionController {
    private final QuestionRepo questionRepo;

    public QuestionController(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    @GetMapping("/{difficulty}")
    public ArrayList<Question> questionList(@PathVariable("difficulty") String difficulty) {
        ArrayList<Question> questionsFromDB = (ArrayList<Question>) questionRepo.findAll();
        ArrayList<Question> correctDifficultyQuestions = new ArrayList<>();
        System.out.println("сложность: " + difficulty);
        for (var question: questionsFromDB) {
            System.out.println(question);
            if (question.getDifficulty().equals(difficulty)) {
                correctDifficultyQuestions.add(question);
            }
        }

        return correctDifficultyQuestions;
    }

}
