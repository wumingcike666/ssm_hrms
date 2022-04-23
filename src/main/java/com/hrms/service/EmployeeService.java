package com.hrms.service;

import com.hrms.bean.Employee;

import java.util.List;

public interface EmployeeService {

    public int getEmpCount();

    public List<Employee> getEmpList(Integer offset, Integer limit);

    public Employee getEmpById(Integer empId);

    public Employee getEmpByName(String empName);

    public int updateEmpById(Integer empId, Employee employee);

    public int deleteEmpById(Integer empId);

    public int addEmp(Employee employee);

}
