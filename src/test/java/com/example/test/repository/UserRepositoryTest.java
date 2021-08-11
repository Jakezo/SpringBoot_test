package com.example.test.repository;

import com.example.test.TestApplicationTests;
import com.example.test.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends TestApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setName("user3");
        user.setEmail("user3@gmail.com");
        user.setPhoneNumber("010-4444-4444");
        user.setRegDt(LocalDateTime.now());
        user.setRegUser("user3Id");

        User newUser = userRepository.save(user);
        System.out.println(newUser);
    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById((long) 2);
        // findId 값으로 찾는것이다 findId(long 값을 써야함 : (long) id숫자 또는  id숫자L  이런 방식으로
        
        //Optional 객체가 감싸고 있는 값이 존재할 경우에만 실행 로직을 함수형 인자로 넘김
        //user.ifPresent(System.out::println);
        user.ifPresent(selectUser -> {
            System.out.println("user: " + selectUser);

        });
        /* user.ifPresent(new UserRepository(){
            void printBoy(User selectUser){
                System.out.println(selectUser);
            }
        }); 나중에 */

    }

    @Test
    // @Transactional
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setName("modUser1");
            selectUser.setEmail("@nave.com");
            selectUser.setRegDt(LocalDateTime.now());
            selectUser.setModUser("cakim21222");
            User newUser = userRepository.save(selectUser);
            System.out.println("user:" + newUser);
        });
    }

    @Test
   // @Transactional      롤백 해주는거
    public void delete(){

        Optional<User> user = userRepository.findById(3L);
        Assertions.assertTrue(user.isPresent()); // true
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
        Optional<User> deleteUser = userRepository.findById(3L);
        Assertions.assertFalse(deleteUser.isPresent()); //true

        if(user == null){
            throw new IllegalArgumentException("삭제할 Id 값이 존재하지 않는다");
        }
    }

}
