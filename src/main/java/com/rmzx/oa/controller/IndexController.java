package com.rmzx.oa.controller;


import com.rmzx.oa.entity.Department;
import com.rmzx.oa.entity.Employee;
import com.rmzx.oa.entity.Node;
import com.rmzx.oa.entity.User;
import com.rmzx.oa.service.DepartmentService;
import com.rmzx.oa.service.EmployeeService;
import com.rmzx.oa.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class IndexController {
    @Resource
    private EmployeeService employeeService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private UserService userService;

    @GetMapping("/")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("/login");
        return modelAndView;
    }

    @GetMapping("/index")
    public ModelAndView showIndex(HttpServletRequest request) {
        HttpSession session = request.getSession();
        //得到当前登录用户对象
        User user = (User) session.getAttribute("login_user");
        //获取当前登录的员工对象
        Employee employee = employeeService.selectById(user.getEmployeeId());
        //获取员工对应的部门
        Department department = departmentService.selectById(employee.getDepartmentId());
        //获取登录用户可用功能模块列表
        List<Node> nodeList = userService.selectNodeByUserId(user.getUserId());
        //放入请求属性
        request.setAttribute("node_list",nodeList);
        session.setAttribute("current_employee",employee);
        session.setAttribute("current_department",department);
        ModelAndView modelAndView = new ModelAndView("/index");

        return modelAndView;
    }
}
