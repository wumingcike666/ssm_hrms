package com.hrms.bean;

import com.hrms.mapper.DepartmentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DeparmentTest {

    static String resource = "mybatis-config.xml";
    static InputStream inputStream = null;
    static SqlSessionFactory sqlSessionFactory = null;
    static SqlSession sqlSession = null;

    static{
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectOneById() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = new Department(1, "王旭1号", "开发部");
        int res = mapper.updateDeptById(department);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertDeptTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = new Department(6, "王旭6号", "人力资源部");
        int res = mapper.insertDept(department);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteDeptByIdTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        int res = mapper.deleteDeptById(6);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectDeptListTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.selectDeptList();
        for(Department department: departments){
            System.out.println(department);
        }

        sqlSession.close();
    }

    @Test
    public void selectOneByIdTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.selectOneById(1);
        System.out.println(department);

        sqlSession.close();
    }

    @Test
    public void selectOneByLeaderTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.selectOneByLeader("王旭1号");
        System.out.println(department);

        sqlSession.close();
    }

    @Test
    public void selectOneByNameTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.selectOneByName("测试部");
        System.out.println(department);

        sqlSession.close();
    }

    @Test
    public void selectDeptsByLimitAndOffsetTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        List<Department> departments = mapper.selectDeptsByLimitAndOffset(2, 3);
        for (Department department: departments){
            System.out.println(department);
        }
        sqlSession.close();
    }

    @Test
    public void checkDeptsExistsByNameAndleaderTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        int res = mapper.checkDeptsExistsByNameAndleader("人力资源部", "王旭6号");
        System.out.println(res);
        sqlSession.close();
    }

    @Test
    public void countDeptsTest() throws IOException {
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        int res = mapper.countDepts();
        System.out.println(res);
        sqlSession.close();
    }
}
