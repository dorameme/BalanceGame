package kimyunsoo.balancegame.user.service;

import kimyunsoo.balancegame.user.dto.User;
import kimyunsoo.balancegame.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String name){
        userRepository.save(new User(name));
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
    public void updateUser(String name){
        User user= userRepository.findByName(name);
        if(user==null){
            throw new IllegalArgumentException();
        }
        user.updateName(name);
        userRepository.save(user);
    }
    
    public void deleteUser(String name){
        User user= userRepository.findByName(name);
        if(user==null){
            throw new IllegalArgumentException();
        }
        userRepository.delete(user);
    }
}
