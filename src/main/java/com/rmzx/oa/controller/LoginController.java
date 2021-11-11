package com.rmzx.oa.controller;

import com.rmzx.oa.entity.User;
import com.rmzx.oa.service.UserService;
import com.rmzx.oa.service.exception.BussinessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Resource
    private UserService userService;

    /**
     * 检查用户登录
     */
    @PostMapping("/check_login")
    @ResponseBody
    public Map checkLogin(String username, String password, HttpServletRequest request) {
        Map result = new HashMap();
        try {
            User user = userService.checkLogin(username, password);
            HttpSession session = request.getSession();
            session.setAttribute("login_user", user);

            result.put("code", "0");
            result.put("msg", "success");
            result.put("redirect_url", "/index");
        }catch (BussinessException ex){
            ex.printStackTrace();
            result.put("code", ex.getCode());
            result.put("msg", ex.getMsg());
        }
        return result;
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        response.sendRedirect("/");
    }
}
