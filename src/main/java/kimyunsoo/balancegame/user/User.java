package kimyunsoo.balancegame.user;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id=null;

    public User(){
    }

    @Column(nullable=false,length = 20)
    private String name;

    public User(String name){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name이 들어왔습니다"));
        }
        this.name=name;
    }
    public void updateName(String name){
        this.name=name;
    }
}
