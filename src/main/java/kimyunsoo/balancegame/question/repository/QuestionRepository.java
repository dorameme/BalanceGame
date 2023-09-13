package kimyunsoo.balancegame.question.repository;

import kimyunsoo.balancegame.question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
