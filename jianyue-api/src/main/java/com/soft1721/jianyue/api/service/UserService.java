package com.soft1721.jianyue.api.service;

import com.soft1721.jianyue.api.entity.User;
import com.soft1721.jianyue.api.entity.dto.UserDTO;


public interface UserService {

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    User getUserByMobile(String mobile);

    /**
     * 根据用户ID获取用户信息
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 登录方法
     *
     * @param userDTO
     * @return boolean
     */
    int signIn(UserDTO userDTO);


    /**
     * 修改头像方法
     *
     * @param user
     * @return boolean
     */
    void update(User user);

    void updateUser1(User user);

    User insert(User user);

    int signUp(UserDTO userDTO);

}