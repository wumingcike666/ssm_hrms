package com.hrms.mapper.impl;

import com.hrms.bean.Department;
import com.hrms.mapper.DepartmentMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class DepartmentMapperImpl implements DepartmentMapper{

    DepartmentMapper departmentMapper;
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public int insertDept(Department dept) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.insertDept(dept);
    }

    public int deleteDeptById(Integer deptId) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.deleteDeptById(deptId);
    }

    public int updateDeptById(Department dept) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.updateDeptById(dept);
    }

    public List<Department> selectDeptList() {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.selectDeptList();
    }

    public Department selectOneById(Integer deptId) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.selectOneById(deptId);
    }

    public Department selectOneByLeader(String deptLeader) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.selectOneByLeader(deptLeader);
    }

    public Department selectOneByName(String deptName) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.selectOneByName(deptName);
    }

    public List<Department> selectDeptsByLimitAndOffset(Integer offset, Integer limit) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.selectDeptsByLimitAndOffset(offset, limit);
    }

    public int checkDeptsExistsByNameAndleader(String deptName, String LeaderName) {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.checkDeptsExistsByNameAndleader(deptName, LeaderName);
    }

    public int countDepts() {
        departmentMapper = sqlSession.getMapper(DepartmentMapper.class);
        return departmentMapper.countDepts();
    }
}
