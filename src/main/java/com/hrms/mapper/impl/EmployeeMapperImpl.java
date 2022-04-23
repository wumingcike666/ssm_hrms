package com.hrms.mapper.impl;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class EmployeeMapperImpl implements EmployeeMapper {
    EmployeeMapper employeeMapper;
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int deleteOneById(Integer empId) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.deleteOneById(empId);
    }

    public int updateOneById(Integer empId, Employee employee) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.updateOneById(empId, employee);
    }

    public int insertOne(Employee employee) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.insertOne(employee);
    }

    public Employee selectOneById(Integer empId) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.selectOneById(empId);
    }

    public Employee selectOneByName(String empName) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.selectOneByName(empName);
    }

    public Employee selectWithDeptById(Integer empId) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.selectWithDeptById(empId);
    }

    public List<Employee> selectByLimitAndOffsert(Integer offset, Integer limit) {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return employeeMapper.selectByLimitAndOffsert(offset, limit);
    }

    public int countEmps() {
        employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        return this.employeeMapper.countEmps();
    }

}
