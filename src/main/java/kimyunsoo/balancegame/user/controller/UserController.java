package kimyunsoo.balancegame.user.controller;

import kimyunsoo.balancegame.user.dto.User;
import kimyunsoo.balancegame.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestParam String name){
        userService.saveUser(name);
    }

    @GetMapping("/user")
    public List<User> getUsers(){
        return userService.getUser();
    }

    @PutMapping("/user")
    public void updateUser(@RequestParam String name){
        userService.updateUser(name);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);
    }
}

