package com.rmzx.oa.service;

import com.rmzx.oa.entity.Department;
import com.rmzx.oa.entity.Employee;

public interface DepartmentService {

    /**
     * 按部门id查找
     * @param departmentId
     * @return
     */
    public Department selectById(Long departmentId);
}
