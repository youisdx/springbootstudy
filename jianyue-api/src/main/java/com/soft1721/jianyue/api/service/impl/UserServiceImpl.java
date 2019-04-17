package com.soft1721.jianyue.api.service.impl;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;
import com.soft1721.jianyue.api.mapper.UserMapper;
import com.soft1721.jianyue.api.service.UserService;
import com.soft1721.jianyue.api.util.StatusConst;
import com.soft1721.jianyue.api.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByMobile(String mobile) {
        return userMapper.getUserByMobile(mobile);
    }

    @Override
    public int signIn(UserDTO userDTO) {
        User user = userMapper.getUserByMobile(userDTO.getMobile());
        //手机号存在
        if (user != null) {
            //密码正确
            if (userDTO.getPassword().equals(user.getPassword())) {
                //账号正常
                if (user.getStatus() == 1) {
                    user.setToken(StringUtil.getUUIDString());
                    userMapper.update(user);
                    return StatusConst.SUCCESS;
                } else {  //账号异常
                    return StatusConst.USER_STATUS_ERROR;
                }
            } else {  //密码错误
                return StatusConst.PASSWORD_ERROR;
            }
        } else {  //手机号不存在
            return StatusConst.USER_MOBILE_NOT_FOUND;
        }
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);

    }

    @Override
    public void updateUser1(User user) {
        userMapper.updateUser1(user);

    }

    @Override
    public User insert(User user) {
        userMapper.insert(user);
        return user;
    }

    @Override
    public int signUp(UserDTO userDTO) {
        //先根据手机号找用户是否存在
        User user = userMapper.getUserByMobile(userDTO.getMobile());
        if (user != null) {
            return StatusConst.MOBILE_EXIST;
        } else {
            User user1 = new User();
            user1.setMobile(userDTO.getMobile());
            user1.setPassword(StringUtil.getBase64Encoder(userDTO.getPassword()));
            user1.setNickname("新用户");
            user1.setAvatar
                    ("data:image/jpeg;base64,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");
            user1.setRegtime(new Date());
            user1.setStatus((short) 1);
            userMapper.insert(user1);
            return StatusConst.SUCCESS;
        }
    }


}