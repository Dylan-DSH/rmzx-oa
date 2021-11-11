package com.rmzx.oa.service.impl;

import com.rmzx.oa.entity.Employee;
import com.rmzx.oa.mapper.EmployeeMapper;
import com.rmzx.oa.service.EmployeeService;
import com.rmzx.oa.utils.MybatisUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("employeeService")
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 按编号查找员工
     *
     * @param employeeId 员工编号
     * @return 员工对象, 不存在时返回null
     */
    public Employee selectById(Long employeeId) {
        Employee employee = employeeMapper.selectById(employeeId);
        return employee;
    }
}
