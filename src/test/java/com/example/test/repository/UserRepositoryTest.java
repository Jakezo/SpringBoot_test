package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends TestApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setName("user1");
        user.setEmail("wowodlr21@gmail.com");
        user.setPhoneNumber("010-3333-3333");
        user.setRegDt(LocalDateTime.now());
        user.setRegUser("ching21");

        User newUser = userRepository.save(user);
        System.out.println(newUser);

    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);
        });




    }
    @Test
    @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setName("modUser1");
            selectUser.setEmail("cakim21@nave.com");
            selectUser.setRegDt(LocalDateTime.now());
            selectUser.setModUser("cakim21");
            User newUser = userRepository.save(selectUser);
            System.out.println("user:" + newUser);

        });
    }
    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(1L);

       user.ifPresent(selectUser ->{
           userRepository.delete(selectUser);
       });
       Optional<User> deleteUser = userRepository.findById(1L);


    }

}
