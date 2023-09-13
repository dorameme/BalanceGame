package kimyunsoo.balancegame.game.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kimyunsoo.balancegame.question.Question;
import kimyunsoo.balancegame.question.service.QuestionService;
import kimyunsoo.balancegame.user.User;
import kimyunsoo.balancegame.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Slf4j
@Controller
public class GameController {


    UserService userService;
    QuestionService questionService;

    public GameController(UserService userService, QuestionService questionService) {
        this.userService = userService;
        this.questionService = questionService;
    }

    @PostMapping("/user")
    public RedirectView saveUser(@RequestParam String name, HttpServletRequest request) {
        userService.saveUser(name);
        HttpSession session = request.getSession();
        session.setAttribute("userName", name);
        questionService.setId(1L);
        return new RedirectView("/question");
    }

    @GetMapping("/question")
    public String game(Model model, HttpServletRequest request) {
        // 세션에서 사용자 이름 읽기
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        // 모델에 사용자 이름 추가
        String Q=questionService.getOneQuestion();
        log.info("{}",Q);
        model.addAttribute("userName", userName);
        model.addAttribute("question",Q);
        return "game"; // 게임 페이지로 이동
    }
}
//    }
//    @GetMapping("/user")
//    public List<User> getUsers(){
//
//        return userService.getUser();
//    }
//
//    @PutMapping("/user")
//    public void updateUser(@RequestParam String name1,String name2){
//        userService.updateUser(name1,name2);
//    }
//
//    @DeleteMapping("/user")
//    public void deleteUser(@RequestParam String name){
//        userService.deleteUser(name);
//    }
//
//    @PostMapping("/question")
//    public void saveQuestion(@RequestParam String name) {
//        questionService.saveQuestion(name);
//
//    }
//    @GetMapping("/question")
//    public Question getQuestion(Long id){
//        return questionService.getOneQuestion();
//    }
//
//    @PutMapping("/question")
//    public void updateScore(@RequestParam Long id,String dir){
//        questionService.updateScore(id,dir);
//    }
//
//    @DeleteMapping("/question")
//    public void deleteQuestion(@RequestParam Long id){
//        questionService.deleteQuestion(id);
//    }
//}
//
