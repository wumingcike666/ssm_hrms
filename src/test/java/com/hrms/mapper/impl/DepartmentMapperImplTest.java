package com.hrms.mapper.impl;

import com.hrms.bean.Department;
import com.hrms.mapper.impl.DepartmentMapperImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class DepartmentMapperImplTest {

    @Test
    public void insertDeptTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        Department department = new Department(8, "董事会", "王旭7号");
        int res = departmentMapper.insertDept(department);
        System.out.println(res);
    }

    @Test
    public void deleteDeptByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        int res = departmentMapper.deleteDeptById(7);
        System.out.println(res);
    }

    @Test
    public void updateDeptByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        Department department = new Department(7, "王旭7号", "股东层");
        int res = departmentMapper.updateDeptById(department);
        System.out.println(res);
    }

    @Test
    public void selectDeptListTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        List<Department> departments = departmentMapper.selectDeptList();
        for(Department department: departments){
            System.out.println(department);
        }
    }

    @Test
    public void selectOneByIdTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        Department department = departmentMapper.selectOneById(1);
        System.out.println(department);
    }

    @Test
    public void selectOneByLeaderTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        Department department = departmentMapper.selectOneByLeader("王旭1号");
        System.out.println(department);
    }

    @Test
    public void selectOneByNameTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        Department department = departmentMapper.selectOneByName("测试部");
        System.out.println(department);
    }

    @Test
    public void selectDeptsByLimitAndOffsetTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        List<Department> departments = departmentMapper.selectDeptsByLimitAndOffset(1, 3);
        for(Department department: departments){
            System.out.println(department);
        }
    }

    @Test
    public void checkDeptsExistsByNameAndleaderTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        int res = departmentMapper.checkDeptsExistsByNameAndleader("测试部", "");
        System.out.println(res);
    }

    @Test
    public void countDeptsTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DepartmentMapperImpl departmentMapper = (DepartmentMapperImpl) context.getBean("departmentMapper");
        int res = departmentMapper.countDepts();
        System.out.println(res);
    }

}
