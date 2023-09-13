package kimyunsoo.balancegame.question;

import jakarta.persistence.*;


@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "right_score", nullable = false)
    private Long rightScore;

    @Column(name = "left_score", nullable = false)
    private Long leftScore;

    @Column(name = "choice", nullable = false, length = 2500)
    private String choice;

    public Question() {
    }
    public Question(String choice) {
        this.rightScore = 0L;
        this.leftScore = 0L;
        this.choice = choice;
    }

    // Getter 및 Setter 메서드
    public Long getId() {
        return id;
    }


    public Long getRightScore() {
        return rightScore;
    }

    public void setRightScore(Long rightScore) {
        this.rightScore = rightScore;
    }

    public Long getLeftScore() {
        return leftScore;
    }

    public void setLeftScore(Long leftScore) {
        this.leftScore = leftScore;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }


}

