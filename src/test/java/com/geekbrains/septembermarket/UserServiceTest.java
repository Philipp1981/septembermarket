package com.geekbrains.septembermarket;

import com.geekbrains.septembermarket.entities.User;
import com.geekbrains.septembermarket.repositories.UserRepository;
import com.geekbrains.septembermarket.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findOneUserTest() {
        User userFromDB = new User();
        userFromDB.setPhone("89380000000");
        userFromDB.setEmail("admin@mail.ru");
        Mockito.doReturn(userFromDB)
                .when(userRepository)
                .findOneByPhone("89380000000");
        User userJohn = userService.findByPhone("89380000000");
        Assert.assertNotNull(userJohn);
        Mockito.verify(userRepository, Mockito.times(1)).findOneByPhone(ArgumentMatchers.eq("89380000000"));
//        Mockito.verify(userRepository, Mockito.times(1)).findOneByPhone(ArgumentMatchers.any(String.class));
    }
}
