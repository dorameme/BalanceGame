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
    public void setBeforeId() {
        this.id = id - 2;
        if(id < 1L)
            id=(Long)questionRepository.count();
    }
    public Long leftPercentage(){

        Question question= questionRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        Long leftScore=question.getLeftScore();
        Long rightScore=question.getRightScore();

        if(leftScore==0L){
           if( leftScore==rightScore )
            return 50L;
           return 0L;
        }
        return (leftScore*100L)/(leftScore+rightScore);
    }
    public Long rightPercentage(){
        return 100L-leftPercentage();
    }
    public void saveQuestion(String choice){ questionRepository.save(new Question(choice));
    }
    public String getOneQuestion(){
        if(id > questionRepository.count()){
            id=1L;
        }
        Question choice=questionRepository.findById(id++)
                .orElseThrow(IllegalArgumentException::new);
        if(id > questionRepository.count()){
            id=1L;
        }
       return choice.getChoice();
    }


    public void updateRightScore(){
        Question question =  questionRepository.findById(getId())
                .orElseThrow(IllegalArgumentException::new);

        question.setRightScore(question.getRightScore()+1);
        questionRepository.save(question);


    }
    public void updateLeftScore(){
        Question question =  questionRepository.findById(getId())
                .orElseThrow(IllegalArgumentException::new);

        question.setLeftScore(question.getLeftScore()+1);
        questionRepository.save(question);
    }


    public void deleteQuestion() {
        Question question = questionRepository.findById(getId())
                .orElseThrow(IllegalArgumentException::new);
        if (question == null) {
            throw new IllegalArgumentException();
        }
        questionRepository.delete(question);
    }
    public Long getId(){
        if(id==1L)return questionRepository.count();
        else return id-1L;
    }
}
