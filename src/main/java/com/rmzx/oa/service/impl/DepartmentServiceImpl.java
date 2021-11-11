package com.rmzx.oa.service.impl;

import com.rmzx.oa.entity.Department;
import com.rmzx.oa.mapper.DepartmentMapper;
import com.rmzx.oa.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("departmentService")
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;
    /**
     * 按部门id查找
     * @param departmentId
     * @return
     */
    public Department selectById(Long departmentId) {
        Department department = departmentMapper.selectById(departmentId);
        return department;
    }

}
