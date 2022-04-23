package com.hrms.service;

import com.hrms.bean.Department;

import java.util.List;

public interface DepartmentService {

    public int deleteDeptById(Integer deptId);

    public int updateDeptById(Department department);

    public int addDept(Department department);

    public int getDeptCount();

    public List<Department> getDeptList(Integer offset, Integer limit);

    public Department getDeptById(Integer deptId);

    public Department getDeptByName(String deptName);

    public List<Department> getDeptName();

}
