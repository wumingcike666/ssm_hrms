package com.hrms.mapper.impl;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeMapperImplTest {

    @Test
    public void countEmpsTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        int count = emlpoyeeMapper.countEmps();
        System.out.println(count);
    }

    @Test
    public void updateOneByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        Employee employee = new Employee("xiaowang", "12345678@qq,com", "男", 1);
        int count = emlpoyeeMapper.updateOneById(1, employee);
        System.out.println(count);
    }

    @Test
    public void insertOneTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        Employee employee = new Employee("前八", "12345678@qq,com", "男", 3);
        int count = emlpoyeeMapper.insertOne(employee);
        System.out.println(count);
    }

    @Test
    public void selectOneByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        Employee employee = emlpoyeeMapper.selectOneById(1);
        System.out.println(employee);
    }

    @Test
    public void selectOneByNameTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        Employee employee = emlpoyeeMapper.selectOneByName("xiaowang");
        System.out.println(employee);
    }

    @Test
    public void selectWithDeptByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        Employee employee = emlpoyeeMapper.selectWithDeptById(1);
        System.out.println(employee);
    }

    @Test
    public void selectByLimitAndOffsertTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeMapper emlpoyeeMapper = (EmployeeMapper) context.getBean("employeeMapper");
        List<Employee> employees = emlpoyeeMapper.selectByLimitAndOffsert(1, 3);
        for(Employee employee: employees){
            System.out.println(employee);
        }
    }


}
