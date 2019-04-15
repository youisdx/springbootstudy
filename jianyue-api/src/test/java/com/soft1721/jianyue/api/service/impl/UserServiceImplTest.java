package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;
import com.soft1721.jianyue.api.service.UserService;
import com.soft1721.jianyue.api.util.StatusConst;
import com.soft1721.jianyue.api.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void getUserByMobile() {
        User user = userService.getUserByMobile("18362956258");
        System.out.println(user);
    }

    @Test
    public void signIn() {
        UserDTO loginUser = new UserDTO();
        loginUser.setMobile("18362956258");
        String base64Pass = StringUtil.getBase64Encoder("111");
        loginUser.setPassword(base64Pass);
        int status = userService.signIn(loginUser);
        assertEquals(StatusConst.SUCCESS, status);
    }

    @Test
    public void getUserById() {
        User user = userService.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        User user=userService.getUserById(1);
        user.setAvatar("1.jpeg");
        userService.update(user);

    }
    @Test
    public void updateUser1(){
        User user=userService.getUserById(1);
        user.setNickname("Jay3");
        userService.updateUser1(user);
    }

    //注册插入测试
    @Test
    public void signUp() {
        UserDTO userDTO = new UserDTO();
        userDTO.setMobile("18136653635");
        userDTO.setPassword("111");
        int n = userService.signUp(userDTO);
        assertEquals(0, n);
    }


}