package com.mlj.test;

import com.mlj.service.UserService;
import com.mlj.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void test(){
        boolean login = userService.login("孟林洁", 0);
        System.out.print(login);
    }
}
