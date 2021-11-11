package com.rmzx.oa.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rmzx.oa.entity.Node;
import com.rmzx.oa.entity.User;
import com.rmzx.oa.mapper.UserMapper;
import com.rmzx.oa.service.UserService;
import com.rmzx.oa.service.exception.BussinessException;
import com.rmzx.oa.utils.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     * 根据前台输入进行登录校验
     *
     * @param username 前台输入的用户名
     * @param password 前台输入的密码
     * @return 校验通过后, 包含对应用户数据的User实体类
     * @throws BussinessException L001-用户名不存在,L002-密码错误
     */
    public User checkLogin(String username, String password) {
        //按用户名查询用户
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.eq("username", username);
        User user = userMapper.selectOne(userQueryWrapper);
        if (user == null) {
            //抛出用户不存在的异常
            throw new BussinessException("L001", "用户名不存在");
        }
        //对前台输入的密码加盐混淆后生成MD5,与保存在数据库中的MD5密码进行比对
        String md5 = MD5Utils.md5Digest(password, user.getSalt());
        if (!md5.equals(user.getPassword())) {
            //密码错误的情况
            throw new BussinessException("L002", "密码错误");
        }
        return user;
    }

    public List<Node> selectNodeByUserId(Long userId) {
        List<Node> nodes = userMapper.selectNodeByUserId(userId);
        return nodes;
    }
}
