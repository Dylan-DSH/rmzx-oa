package com.rmzx.oa.service.impl;

import com.rmzx.oa.entity.Node;
import com.rmzx.oa.mapper.UserMapper;
import com.rmzx.oa.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    @Resource
    private UserService userService;
    @Test
    public void checkLogin() {
    }

    @Test
    public void selectNodeByUserId() {
        List<Node> nodes = userService.selectNodeByUserId(1l);
        System.out.println(nodes);

    }
}