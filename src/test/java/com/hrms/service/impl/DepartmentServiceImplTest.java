package com.hrms.service.impl;

import com.hrms.bean.Department;
import com.hrms.service.DepartmentService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentServiceImplTest {

    @Test
    public void deleteDeptByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        departmentService.deleteDeptById(1);
    }

    @Test
    public void updateDeptByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        Department department = new Department(1, "王旭1号", "研发部");
        int res = departmentService.updateDeptById(department);
        System.out.println(res);
    }

    @Test
    public void addDeptTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        /*Department department = new Department(7, "王旭7号", "开发部");*/
        Department department = new Department(null, "null", "null");
        int res = departmentService.addDept(department);
        System.out.println(res);
    }

    @Test
    public void getDeptCountTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        int res = departmentService.getDeptCount();
        System.out.println(res);
    }

    @Test
    public void getDeptListTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        List<Department> deptList = departmentService.getDeptList(1, 3);
        for (Department department: deptList){
            System.out.println(department);
        }
    }

    @Test
    public void getDeptByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        Department department = departmentService.getDeptById(1);
        System.out.println(department);
    }

    @Test
    public void getDeptByNameTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        Department department = departmentService.getDeptByName("研发部");
        System.out.println(department);
    }

    @Test
    public void getDeptNameTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentService departmentService = (DepartmentService) context.getBean("departmentService");
        List<Department> departments = departmentService.getDeptName();
        for(Department department: departments){
            System.out.println(department);
        }
    }
}
