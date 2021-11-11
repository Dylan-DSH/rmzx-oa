package com.rmzx.oa.service;

import com.rmzx.oa.entity.Employee;
import com.rmzx.oa.entity.User;
import com.rmzx.oa.service.exception.BussinessException;
import com.rmzx.oa.utils.MybatisUtils;

public interface EmployeeService {


    /**
     * 按编号查找员工
     * @param employeeId 员工编号
     * @return 员工对象, 不存在时返回null
     */
    public Employee selectById(Long employeeId);
}
