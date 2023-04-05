package quiz.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Table
@Entity
@Getter
@Setter
@ToString(of = {"id", "difficulty", "text"})
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String difficulty;
    private String text;
    private String answer;
}
