package kimyunsoo.balancegame.user.service;

import kimyunsoo.balancegame.user.User;
import kimyunsoo.balancegame.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean saveUser(String name){
        if(userRepository.existsByName(name)){return false;}
        userRepository.save(new User(name));
        return true;
    }
    public List<User> getUser(){
        return userRepository.findAll();
    }
    public void updateUser(String name1,String name2){
        User user= userRepository.findByName(name1);
        if(user==null){
            throw new IllegalArgumentException();
        }
        user.updateName(name2);
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
