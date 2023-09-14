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
    public RedirectView saveUser(@RequestParam String name, Model model,HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(!userService.saveUser(name)){
           return new RedirectView("/start2.html");
        }
        session.setAttribute("userName", name);
        questionService.setId(1L);
        return new RedirectView("/nextQuestion");
    }

    @GetMapping("/nextQuestion")
    public String nextGame(Model model, HttpServletRequest request) {
        // 세션에서 사용자 이름 읽기
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        // 모델에 사용자 이름 추가
        String Q=questionService.getOneQuestion();

        model.addAttribute("LeftPercent",questionService.leftPercentage());
        model.addAttribute("RightPercent",questionService.rightPercentage());
        model.addAttribute("userName", userName);
        model.addAttribute("question",Q);
        return "game"; // 게임 페이지로 이동
    }
    @GetMapping("/beforeQuestion")
    public String beforeGame(Model model, HttpServletRequest request) {
        // 세션에서 사용자 이름 읽기
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        // 모델에 사용자 이름 추가
        questionService.setBeforeId();
        String Q=questionService.getOneQuestion();

        model.addAttribute("LeftPercent",questionService.leftPercentage());
        model.addAttribute("RightPercent",questionService.rightPercentage());
        model.addAttribute("userName", userName);
        model.addAttribute("question",Q);
        return "game"; // 게임 페이지로 이동
    }

    @GetMapping("/leftQuestion")
    public String checkedLeft(Model model, HttpServletRequest request) {

        questionService.updateLeftScore();

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String Q=questionService.getOneQuestion();

        model.addAttribute("LeftPercent",questionService.leftPercentage());
        model.addAttribute("RightPercent",questionService.rightPercentage());
        model.addAttribute("userName", userName);
        model.addAttribute("question",Q);
        return "game"; // 게임 페이지로 이동
    }
    @GetMapping("/rightQuestion")
    public String checkedRight(Model model, HttpServletRequest request) {
        questionService.updateRightScore();

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("userName");
        String Q=questionService.getOneQuestion();

        model.addAttribute("LeftPercent",questionService.leftPercentage());
        model.addAttribute("RightPercent",questionService.rightPercentage());
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
