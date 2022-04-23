package com.hrms.service.impl;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import com.hrms.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeMapper employeeMapper;

    public void setEmployeeMapper(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    public int getEmpCount() {
        return employeeMapper.countEmps();
    }

    public List<Employee> getEmpList(Integer offset, Integer limit) {
        return employeeMapper.selectByLimitAndOffsert(offset, limit);
    }

    public Employee getEmpById(Integer empId) {
        return employeeMapper.selectOneById(empId);
    }

    public Employee getEmpByName(String empName) {
        return employeeMapper.selectOneByName(empName);
    }

    public int updateEmpById(Integer empId, Employee employee) {
        return employeeMapper.updateOneById(empId,employee);
    }

    public int deleteEmpById(Integer empId) {
        return employeeMapper.deleteOneById(empId);
    }

    public int addEmp(Employee employee) {
        return employeeMapper.insertOne(employee);
    }

}
