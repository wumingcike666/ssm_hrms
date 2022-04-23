package com.hrms.bean;

import com.hrms.mapper.EmployeeMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EmployeeTest {

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
    public void deleteOneByIdTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int res = mapper.deleteOneById(6);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateOneByIdTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(5, "赵六", "123456@qq.com", "妖", 3);
        int res = mapper.updateOneById(5, employee);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertOneTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee("孙七", "123456@qq.com", "女", 4);
        int res = mapper.insertOne(employee);
        System.out.println(res);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectOneByIdTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOneById(1);
        System.out.println(employee);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectOneByNameTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectOneByName("王旭");
        System.out.println(employee);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectWithDeptByIdTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.selectWithDeptById(1);
        System.out.println(employee);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByLimitAndOffsertTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = mapper.selectByLimitAndOffsert(2, 3);
        for(Employee employee: employees){
            System.out.println(employee);
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void countEmpsTest() throws IOException {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = mapper.countEmps();
        System.out.println(i);

        sqlSession.commit();
        sqlSession.close();
    }
}
