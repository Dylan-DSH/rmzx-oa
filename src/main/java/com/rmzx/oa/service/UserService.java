package com.rmzx.oa.service;

import com.rmzx.oa.entity.Node;
import com.rmzx.oa.entity.User;
import com.rmzx.oa.service.exception.BussinessException;

import java.util.List;

public interface UserService {

    /**
     * 根据前台输入进行登录校验
     * @param username 前台输入的用户名
     * @param password 前台输入的密码
     * @return 校验通过后,包含对应用户数据的User实体类
     * @throws BussinessException L001-用户名不存在,L002-密码错误
     */
    public User checkLogin(String username, String password);


    public List<Node> selectNodeByUserId(Long userId);

}
