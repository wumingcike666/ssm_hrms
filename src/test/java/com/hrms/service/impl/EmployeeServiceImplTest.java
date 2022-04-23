package com.hrms.service.impl;

import com.hrms.bean.Employee;
import com.hrms.service.EmployeeService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class EmployeeServiceImplTest {

    @Test
    public void getEmpCountTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        int empCount = employeeService.getEmpCount();
        System.out.println(empCount);
    }

    @Test
    public void getEmpListTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        List<Employee> empLists = employeeService.getEmpList(1, 3);
        for(Employee employee: empLists){
            System.out.println(employee);
        }
    }

    @Test
    public void getEmpByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee employee = employeeService.getEmpById(1);
        System.out.println(employee);
    }

    @Test
    public void getEmpByNameTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee employee = employeeService.getEmpByName("xiaowang");
        System.out.println(employee);
    }

    @Test
    public void updateEmpByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee(1, "小王", "8888@qq.com", "男", 3);
        int res = employeeService.updateEmpById(1, employee);
        System.out.println(res);
    }

    @Test
    public void addEmpTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee employee = new Employee(10, "大王", "8888@qq.com", "男", 5);
        int res = employeeService.addEmp(employee);
        System.out.println(res);
    }

    @Test
    public void deleteEmpByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        int res = employeeService.deleteEmpById(10);
        System.out.println(res);
    }
}
