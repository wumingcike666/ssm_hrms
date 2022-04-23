package com.hrms.service.impl;

import com.hrms.bean.Department;
import com.hrms.mapper.DepartmentMapper;
import com.hrms.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentMapper departmentMapper;

    public void setDepartmentMapper(DepartmentMapper departmentMapper) {
        this.departmentMapper = departmentMapper;
    }

    public int deleteDeptById(Integer deptId) {
        return departmentMapper.deleteDeptById(deptId);
    }

    public int updateDeptById(Department department) {
        return departmentMapper.updateDeptById(department);
    }

    public int addDept(Department department) {
        return departmentMapper.insertDept(department);
    }

    public int getDeptCount() {
        return departmentMapper.countDepts();
    }

    public List<Department> getDeptList(Integer offset, Integer limit) {
        return departmentMapper.selectDeptsByLimitAndOffset(offset, limit);
    }

    public Department getDeptById(Integer deptId) {
        return departmentMapper.selectOneById(deptId);
    }

    public Department getDeptByName(String deptName) {
        return departmentMapper.selectOneByName(deptName);
    }

    public List<Department> getDeptName() {
        return departmentMapper.selectDeptList();
    }
}
