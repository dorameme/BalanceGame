package kimyunsoo.balancegame.question.service;

import kimyunsoo.balancegame.question.Question;
import kimyunsoo.balancegame.question.repository.QuestionRepository;
import kimyunsoo.balancegame.user.User;
import kimyunsoo.balancegame.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService {
    private Long id=1L;
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void saveQuestion(String choice){ questionRepository.save(new Question(choice));
    }
    public String getOneQuestion(){
        Question choice=questionRepository.findById(id++)
                .orElseThrow(IllegalArgumentException::new);
       return choice.getChoice();
    }

    public void updateScore(Long id,String dir){
        if(dir=="L"){
            updateLeftScore(id);
        }
        if(dir=="R")
            updateRightScore(id);
    }
        public void updateRightScore(Long id){
        Question question =  questionRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        question.setRightScore(question.getRightScore()+1);
        questionRepository.save(question);

    }public void updateLeftScore(Long id){
        Question question =  questionRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        question.setLeftScore(question.getLeftScore()+1);
        questionRepository.save(question);
    }


    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        if (question == null) {
            throw new IllegalArgumentException();
        }
        questionRepository.delete(question);
    }
}
